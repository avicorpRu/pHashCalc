# Android library pHashCalc:
Images (JPEG, BMP) comparison (perceptual hash algorithm).

[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![Kotlin version](https://img.shields.io/badge/Kotlin-1.7.20-blue)]([https://kotlinlang.org/docs/whatsnew16.html](https://kotlinlang.org/docs/whatsnew1720.html))
[![mavenCentral](https://img.shields.io/badge/download_Maven-v1.0.1-red)](https://search.maven.org/search?q=ru.avicorp.phashcalc)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)


<img align="center" src="https://github.com/avbase/pHashCalc/blob/main/phashResult.gif" height="180" style="max-width: 50%; display: inline-block;" data-target="animated-image.originalImage">



###  Capabilities pHashCalc: 

Сalculates the percentages of identity of two JPEG(JPG) or BMP files (algorithm pHash).
Also checks the structure of a JPEG (JPG) file against the main signatures.

    - StartOfImage
    - ApplicationDefaultHeader
    - QuantizationTable
    - StartOfFrame
    - DefaultHuffmanTable
    - StartOfScan
    - EndOfImage

## How to use

The project's Maven access is hosted on OSS Sonatype (and available from Maven Central).
Android : pHashCalc supports Android starting on API 26 and up.

#### Using with Gradle

Add the dependencies into the project's build.gradle:
```groovy
repositories {
  mavenCentral()
}

dependencies {
       def phashcalc_version = "1.0.1"
    implementation "ru.avicorp:phashcalc:$phashcalc_version"
}
```

#### Example

```groovy
val phash = pHashCalc()

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

```
##### JPEG
```groovy
// Checking the validity of the JPEG(JPG) by its structure (struct is displayed in the log)
        if (!phashCalc.validJPEGStruct(sourceFileThree)) Log.e("JPEG Struct", "This file is not JPEG(JPG)")
        else Log.e("JPEG Struct", "By JPEG(JPG) signatures, structure is correct")

        //If load BMP, get HEADER else clean data
        phashCalc.getJPEGData()
        //If load JPEG, get HEADER else clean data
        //sizeJPEG - Size of JPEG file (bytes);
        //howHuffmanTableJPEG - How Huffman Table 1-4
        //averageByteJPEG - average byte (raw data, not quantization,header,haffman)
```
##### BMP
```groovy
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
```



### Usage description

The library implements the pHash algorithm that uses perceptual hashes to compare images, (detailed documentation and description of algorithms using perceptual hashes can be found at [pHash](https://pHash.org)), my implementation of this algorithm was used to build a video surveillance system for a private house [Smart Home Video Control](https://avicorp.ru)

### License

 Copyright (C) 2017 The Λvicorp Authors

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.