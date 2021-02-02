# Program Analisa Cuaca Panas dan Dingin Menggunakan Apache Hadoop dan Java

**`Yaitu sebuah program MapReduce untuk Analisa Cuaca Panas dan Dingin dari sebuah wilayah berdasarkan file dataset histori cuaca yang terjadi di wilayah tersebut.`**


### Teknologi yang kami gunakan :
1. Apache Hadoop sebagai Program MapReduce, dan 
2. Java sebagai Back-end yang memberikan instruksi ke Hadoop

## Pre-requisite

**`Sebelum Anda memulai menjalankan projek kami ini, ada beberapa hal penting yang harus Anda persiapkan, diantaranya adalah:`**


- [x] Sudah menginstal **`Git`.** Kalau belum, Anda bisa menginstall nya pada link [di sini](https://git-scm.com/downloads).
- [x] Sudah menginstal **`software IDE`** untuk Java, seperti [Eclipse](https://www.eclipse.org/downloads/), [Netbeans](https://netbeans.org/downloads/8.2/rc/), atau [IntelliJ IDEA](https://www.jetbrains.com/idea/download/).
- [x] Sudah menginstall **`jdk versi 8` ke atas.** *Saya menyarankan Anda untuk mengunduh **jdk versi 11**.*
   > Bagi Anda user **Linux,** langsung saja install **jdk** versi 8 ke atas dengan menggunakan perintah berikut ini di **Terminal**: 

```shell
$ sudo apt-get install openjdk-11-jdk
```
   > Bagi Anda user **Windows,** silahkan unduh `openjdk versi 8 ke atas` pada link [**_di sini_**](https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_windows-x64_bin.zip)**.**
- [x] Sudah menginstall **Apache Hadoop.** Jika belum, Anda dapat mengunduh **_binary file_** **_Hadoop_** nya melalui link [**_di sini_**](https://downloads.apache.org/hadoop/common/hadoop-3.2.2/hadoop-3.2.2.tar.gz). *Kami menyarankan Anda untuk menggunakan versi **Hadoop 3.2.2***
  > Untuk tutorial instalasi dan konfigurasi **Apache Hadoop** pada **Ubuntu 20.04** sudah kami sediakan dalam bentuk PDF. **_Download file here :_** [📖](https://link-google-drive)

![java-and-hadoop-versions](https://user-images.githubusercontent.com/78311798/106405728-cab2ef00-6469-11eb-9b71-b69e7fffb2d2.png)

- [x] Sudah mengunduh **_Jar Hadoop Common_** pada link [**_di sini_**](https://https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-common). *Pastikan Anda mengunduh versi **Jar** nya sesuai dengan versi **Hadoop** Anda*.
  - Bagi Anda user **Linux** dan Anda juga ingin menggunakan **Hadoop Common versi 3.2.2**, Anda dapat menggunakan perintah berikut ini: 

```shell  
$ wget https://repo1.maven.org/maven2/org/apache/hadoop/hadoop-common/3.2.2/hadoop-common-3.2.2.jar
```
- [x] Sudah mengunduh **_Jar Hadoop MapReduce Core_** pada link [**_di sini_**](https://https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-mapreduce-client-core). *Pastikan Anda mengunduh versi **Jar** nya sesuai dengan versi **Hadoop** Anda*.
  - Bagi Anda user **Linux** dan Anda juga ingin menggunakan **Hadoop MapReduce Client Core versi 3.2.2**, Anda dapat menggunakan perintah berikut ini:

```shell
$ wget https://repo1.maven.org/maven2/org/apache/hadoop/hadoop-common/3.2.2/hadoop-mapreduce-client-core-3.2.2.jar
```
![download-jar-hadoop-common-and-hadoop-mapreduce-core](https://user-images.githubusercontent.com/78311798/106408754-a78c3d80-6471-11eb-943f-c222bbb2961a.png)

- [x] Sudah menyediakan sebuah dataset histori cuaca dari sebuah wilayah. Jika belum, Anda bisa mengunduhnya dari link NCDC NOAA berikut ini: [**_ftp://ftp.ncdc.noaa.gov/pub/data/uscrn/products/daily01/2021_**](ftp://ftp.ncdc.noaa.gov/pub/data/uscrn/products/daily01/2021/).
  *Pilih salah satu dataset saja untuk dijadikan sebagai bahan analisa cuaca panas dan dingin yang tejadi pada wilayah tersebut*.
  > **NCDC NOAA (National CLimatic Data Center) adalah sebuah data center dari USA yang menyediakan kumpulan dataset histori cuaca dari berbagai wilayah.**

  > Di sini kami menggunakan dataset cuaca dari negara **Palestina** mulai dari tanggal **1 - 29 Januari 2021.** Bagi Anda yang ingin mengunduh file dataset tersebut, Anda bisa klik tautan [**_di sini_**](https://drive.google.com/file/d/1hdyyUihThvIiZbNxEAdf96VrZ8uOA-1b/view?usp=sharing).

![ncdc-noaa-repository](https://user-images.githubusercontent.com/78311798/106549135-edfd9d00-6542-11eb-8f3f-f449ecacfd28.png)
![dataset-palestine-tanggal-1-sampai-29-januari-2021](https://user-images.githubusercontent.com/78311798/106409735-d3a8be00-6473-11eb-8bcc-ace52c94e8ef.PNG)

  - Berikut ini adalah gambar dari isi file dataset **Palestine** mulai dari tanggal **1 sampai 29 Januari 2021.**

![content-of-palestine-dataset-file](https://user-images.githubusercontent.com/78311798/106537183-69078900-652c-11eb-91da-b99b5b2f40e6.PNG)

--------------------------------------------------
## How To Use This App
**`
Setelah Anda menginstal IDE, JDK, dan Hadoopnya. Sekarang kita lanjut ke tahap development aplikasinya.
`**
> **Pastikan Anda sudah membaca dokumentasi Tutorial Instalasi Hadoop yang sudah saya berikan di atas.**

  - ### **Unduh Projek Kami Menggunakan Git**
      * Pertama, Anda harus mengunduh projek kami dengan menggunakan **`git clone`** ke dalam komputer/laptop Anda dengan menggunakan perintah :
      ```shell
      $ git clone https://github.com/wahyuprmbd/saas-project.git
      ```
      * Tetapi, jika Anda tidak menginstal **git** di komputer/laptop, Anda bisa mengunjungi projek kami yang ada di github dan mengunduh projek kami dalam bentuk **ZIP**. Klik [**_di sini_**](https://github.com/wahyuprmbd/saas-project) untuk menuju ke halaman github projek kami. 
  
  - ### **Memulai Membuat Projek Java di Eclipse**
      * Buka aplikasi **`Eclipse`** untuk memulai development aplikasi big datanya. 
      * Buat **`Java Project`** baru dengan cara :
        * Klik **`icon New`** pada bagian pojok kiri *top bar* >> Berikan nama projek Java nya *(nama projek bebas)* dan pilih opsi **`JRE nya sesuai dengan versi jdk Anda.`**
      * Buat **`Java Package`** di dalam **`Java Project`** dengan cara: 
        * klik kanan folder **`src`** >> **`New`** >> **`Java Package`** >> Berikan nama **`Java projek`** sesuai dengan yang Anda inginkan.
      * Buat **`Java Class`** baru di dalam folder **`src/yourJavaPackageName`** dengan cara: 
        * klik kanan **`Nama Java Package`** Anda >> **`New`** >> **`Java Class`** >> Berikan nama **`Java projek`** sesuai dengan yang Anda inginkan.
      * Tambahkan **`Jar Hadoop Common`** dan **`Jar Hadoop MapReduce Client Core`** yang sudah Anda unduh sebelumnya ke dalam **`Java Project`** Anda dengan cara :
        * Klik kanan pada **`Nama Java Project`** Anda >> Pilih **`Build Path`** >> **`Add External Archives to Java Project`** >> Kemudian masukkan kedua jar eksternal tersebut.
      * Masukkan **_`Source Code`_** yang sudah saya sediakan pada folder **`hadoopProject/src/weatherAnalyzeApp`** >> lalu salin semua kode di dalam file **_`TemperatureMaxMin.java`_** ke dalam **`Java Class`** Anda.

![1-create-a-new-java-project](https://user-images.githubusercontent.com/78311798/106542579-a8d36e00-6536-11eb-8b58-691ed6495c10.PNG)
![2-create-a-new-java-package](https://user-images.githubusercontent.com/78311798/106542734-f0f29080-6536-11eb-9a94-a97a224b1216.PNG)
![3-create-a-new-java-class](https://user-images.githubusercontent.com/78311798/106542880-3b740d00-6537-11eb-95ae-153bc73d72c8.PNG)
![4-add-external-jars](https://user-images.githubusercontent.com/78311798/106542990-72e2b980-6537-11eb-8d0a-d22a9c5fa3bd.PNG)
![5-code-view](https://user-images.githubusercontent.com/78311798/106543127-b63d2800-6537-11eb-9e4b-ba3d90b25812.PNG)

  - ### **Eksport Projek Java Anda Menjadi File Jar**
      * Setelah Anda menyalin semua *source code* yang ada di dalam file **_`TemperatureMaxMin.java`_**, export **`Java Project`** Anda menjadi file **Jar** dengan cara :
        * Klik kanan **`Nama Java Project`** Anda >> **`Export`** >> **`Java`** >> **`Jar File`** >> Tentukan lokasi dimana file **Jar** Anda akan disimpan >> **`Next`** >> **`Next`** >> Pilih **`Main Class`** yang ada di dalam **`Java Package`** Anda.

![6-export-java-project-to-jar-file](https://user-images.githubusercontent.com/78311798/106543441-51ce9880-6538-11eb-9bd7-eaedc39ead90.PNG)
![7-select-destionation-path-to-store-the-jar-file](https://user-images.githubusercontent.com/78311798/106543692-cbff1d00-6538-11eb-8f7a-9bbc1186f259.PNG)
![8-export-jar-file-finished-with-warnings](https://user-images.githubusercontent.com/78311798/106543942-50ea3680-6539-11eb-9db3-c3c8da4e6bd3.PNG)

  - ### **Menjalankan Hadoop Daemons**
      * Pertama, jalankan **`dfs`** dengan mengetikkan perintah :
      ```shell
      $ cd $HADOOP_HOME/sbin/
  
      $ ./start-dfs.sh
      ```

      * Dan yang kedua, jalankan **`yarn`** dengan mengetikkan perintah:
      ```shell
      $ ./start-yarn.sh
      ```
![9-start-hadoop-daemons](https://user-images.githubusercontent.com/78311798/106544228-c2c28000-6539-11eb-9812-c1233cb1f968.PNG)

  - ### **Pindahkan File Dataset Anda ke Hadoop HDFS**
      * Untuk memindahkan file dataset yang Anda punya, gunakan perintah di bawah ini:

      ```shell
      $ hdfs dfs -put /path/to/dataset-file /destination/path
      ```
      Contoh :
      ```shell
      $ hdfs dfs -put /home/hadoop/Documents/saas-project/aplikasi-big-data/palestine-dataset-20210130/CRND0103-2021-TX_Palestine_6_WNW.txt /user/hadoop/dataset/
      ```

      * Untuk mengecek file dataset Anda sudah ada atau belum di dalam **Hadoop HDFS**, gunakan perinah di bawah ini:
      ```shell
      $ hdfs dfs -ls /user/hadoop/dataset/
      ```
![10-put-dataset-file-into-hadoop-hdfs](https://user-images.githubusercontent.com/78311798/106544412-146b0a80-653a-11eb-8e6a-aa12c8414e64.PNG)

  - ### **Jalankan File Jar Anda Menggunakan Hadoop**
      * Selanjutnya, Anda tinggal jalankan saja file **jar hasil export sebelumnya** menggunakan **Hadoop Jar** dengan mengikuti perintah di bawah ini :
      ```shell
      $ hadoop jar /path/to/the-jar-file /hdfs/path/to/dataset-file /hdfs/path/to/store/the/output
      ```

      Contoh : 
      ```shell
      $ hadoop jar weatherAnalyzeApp.jar /user/hadoop/dataset/CRND0103-2021-TX_Palestine_6_WNW.txt /user/hadoop/result
      ```
![11-run-the-jar-file-using-hadoop-jar](https://user-images.githubusercontent.com/78311798/106544655-80e60980-653a-11eb-9feb-4d39923aec5c.PNG)


  - ### **Unduh File Output Hasil dari Pemrosesan Dataset**
      * Pergi ke **_HDFS directory_** tempat dimana *result file* Anda disimpan. *Kalau kami, ada di direktori: **`/user/hadoop/result/`***.
        > Untuk mengakses **_HDFS directory_**, Anda bisa mengakses **`localhost:9870`** pada web browser, kemudian pergi ke **`Utilities/Browse the file system`** untuk melihat *result file* Anda disimpan.
      * Setelah itu, silahkan Anda unduh file **_`part-r-00000`_**

![12-go-to-result-directory-in-hadoop-hdfs](https://user-images.githubusercontent.com/78311798/106545327-cbb45100-653b-11eb-8f3d-dde1f102671d.PNG)
![13-download-the-result-file](https://user-images.githubusercontent.com/78311798/106545632-5f861d00-653c-11eb-825a-8ad802cf24a8.PNG)

  - ### **Tampilkan File Output Hasil dari Pemrosesan Dataset**
      * Setelah Anda mengunduh file output **_`part-r-00000`_**, silahkan buka file tersebut dan lihat sendiri hasilnya.
      * Berikut ini adalah gambar file output **_`(part-r-00000)`_** hasil dari pemrosesan dataset yang kami miliki.

![14-show-the-result-file](https://user-images.githubusercontent.com/78311798/106546287-7e38e380-653d-11eb-949d-9afce034a16c.PNG)

---------------------------------------------------
## Our Team

### **`Members of the group`**
  - Bagus Fathoni 
  - Dafa Abdurrohman
  - Mahesa Adiputra
  - Wahyu Priambodo