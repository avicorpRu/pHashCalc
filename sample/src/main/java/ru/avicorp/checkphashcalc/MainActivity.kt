package ru.avicorp.checkphashcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import ru.avicorp.phashcalc.pHashCalc

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Copy the files in root directory to the downloads folder on your device to check (String)
        val aPath: String =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path //get absolute path to folder download
        val sourceFileOne = "$aPath/sourceOne.jpg"
        val sourceFileTwo = "$aPath/sourceTwo.jpg"
        val sourceFileThree = "$aPath/sourceThree.jpg"
        val sourceFileFour = "$aPath/sourceFour.bmp"

        val phashCalc = pHashCalc()//get to phashCalc library

        //Сalculate the percentages of identity of two JPEG(JPG) or(and) BMP files (algorithm pHash)
        if (phashCalc.loadSourceFile(sourceFileOne, sourceFileFour)) {
            Log.e("pHashCalc", "pHash: ${phashCalc.calculateIdentical()}%")
        } else Log.e("pHashCalc", "Files not found or check permission")

        //Condition: files checked and uploaded else clean data
        if (phashCalc.checkCondition()) {
            //Greyscale hash files
            Log.e("pHashCalc", "Greyscale hash files: ${phashCalc.getHashOne()} vs ${phashCalc.getHashTwo()}")
            //Average pixel greyscale files
            Log.e("pHashCalc", "Average pixel greyscale files: ${phashCalc.getAveragePixelOne()} vs  ${phashCalc.getAveragePixelTwo()}")
        } else Log.e("pHashCalc", "Please load files")

        // Checking the validity of the JPEG(JPG) by its structure (struct is displayed in the log)
        if (!phashCalc.validJPEGStruct(sourceFileThree)) Log.e("JPEG Struct", "This file is not JPEG(JPG)")
        else Log.e("JPEG Struct", "By JPEG(JPG) signatures, structure is correct")

        //If load BMP, get HEADER else clean data
        phashCalc.getJPEGData()
        //If load JPEG, get HEADER else clean data
        //sizeJPEG - Size of JPEG file (bytes);
        //howHuffmanTableJPEG - How Huffman Table 1-4
        //averageByteJPEG - average byte (raw data, not quantization,header,haffman)


        // Checking the validity of the BMP by its signatures (header is displayed in the log)
        if (!phashCalc.validBMPStruct(sourceFileFour)) Log.e("BMP Struct", "This file is not BMP")
        else Log.e("BMP Struct", "By Bitmap Picture signatures, structure is correct")

        phashCalc.getBMPData()
        //If load BMP, get HEADER else clean data
        //sizeBMP -Size of bmp file (bytes);
        //offsetDataBMP - Offset before image data (bytes);
        //headerBMP - Size Header Struct;
        //sizeWidthBMP - Size of Image width (pixels);
        //sizeHeightBMP - Size of Image height (pixels);
        //bitDepthBMP - Depth of color: (bit per pixel);
        //undColDepthBMP - Depth of color: (bit per pixel) (string);
        //horResInMeterBMP - Horizontal resolution (in pixels per meter);
        //vertResInMeterBMP - Vertical resolution (in pixels per meter);
        //numColorImageBMP - Number of colors in the image or zero;
        //numImpotentColorImageBMP - Number of important colors or zero;
        //compressBMP - Compression type;
        //compressTypeBMP - Compression type(string);
        //sizeRAWImageBMP -Size raw image data (bytes)

    }
}