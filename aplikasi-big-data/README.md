# Program Analisa Cuaca Panas dan Dingin Menggunakan `Apache Hadoop` dan `Java`
```markdown
Yaitu sebuah program MapReduce untuk Analisa Cuaca Panas dan Dingin dari Sebuah Wilayah berdasarkan tanggalnya. 
```

### Teknologi yang kami gunakan :
1. Apache Hadoop sebagai Program MapReduce, dan 
2. Java sebagai Back-end yang memberikan instruksi ke Hadoop


## 1. Pre-requisite
```markdown
Sebelum Anda memulai menjalankan projek kami ini, ada beberapa hal penting yang harus Anda persiapkan, diantaranya adalah:
```

* Sudah menginstal **`Git`.** Kalau belum, Anda bisa menginstall nya pada link [di sini](https://git-scm.com/downloads).
* Sudah menginstal **`software IDE`** untuk Java, seperti [Eclipse](https://www.eclipse.org/downloads/), [Netbeans](https://netbeans.org/downloads/8.2/rc/), atau [IntelliJ IDEA](https://www.jetbrains.com/idea/download/).
* Sudah menginstall **`jdk versi 8` ke atas.** *Saya menyarankan Anda untuk mengunduh **jdk versi 11**.*
   > Bagi Anda user **Linux,** langsung saja install **jdk** versi 8 ke atas dengan menggunakan perintah berikut ini di **Terminal** : **`$ sudo apt-get install openjdk-11-jdk`.**

   > Bagi Anda user **Windows,** silahkan unduh `openjdk versi 8 ke atas` pada link [**_di sini_**](https://download.java.net/java/GA/jdk11/13/GPL/openjdk-11.0.1_windows-x64_bin.zip)**.**
* Sudah menginstall **Apache Hadoop.** Jika belum, Anda dapat mengunduh **_binary file_** **_Hadoop_** nya melalui link [**_di sini_**](https://downloads.apache.org/hadoop/common/hadoop-3.2.2/hadoop-3.2.2.tar.gz). *Saya menyarankan Anda untuk menggunakan versi **Hadoop 3.2.2***
  > Untuk tutorial instalasi dan konfigurasi **Apache Hadoop** pada **Ubuntu 20.04** sudah kami sediakan dalam bentuk PDF. **_Download file here :_** [📖](https://link-google-drive)
* Sudah menyediakan sebuah dataset cuaca dari sebuah negara. Jika belum, Anda bisa mengunduhnya dari link NCDC NOAA berikut ini: [ftp://ftp.ncdc.noaa.gov/pub/data/uscrn/products/daily01](ftp://ftp.ncdc.noaa.gov/pub/data/uscrn/products/daily01).
  *Pilih saja satu wilayah untuk kita analisa cuaca panas dan dingin yang terjadi di wilayah tersebut*.
  > **NCDC NOAA (National CLimatic Data Center) adalah sebuah data center dari USA yang menyediakan kumpulan dataset histori cuaca dari berbagai wilayah.**

  > Di sini, kami menggunakan dataset cuaca dari wilayah **Edinburg, Texas, USA** tanggal **30 Januari 2021.** Bagi Anda yang ingin mengunduhnya, Anda bisa klik tautan [**_di sini_**](https://link-google-drive).
![Java & Hadoop Version](/home/hadoop/Pictures/java & hadoop version.png)
  

TO DO LIST :
- [x] Membuat repository SaaS Project
- [ ] Menyelesaikan dokumentasi
- [ ] Membuat file ppt
- [ ] Membuat video demo projek
- [x] Test membuat aplikasi sudah berhasil jalan 