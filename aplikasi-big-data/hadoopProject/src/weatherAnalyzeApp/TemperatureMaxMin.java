package weatherAnalyzeApp; // Nama package nya sesuaikan dengan nama package Anda.

//import semua library yang kita butuhkan.
import java.io.IOException; 
import java.util.Iterator; 
import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat; 
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat; 
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat; 
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat; 
import org.apache.hadoop.mapreduce.Job; 
import org.apache.hadoop.mapreduce.Mapper; 
import org.apache.hadoop.mapreduce.Reducer; 
import org.apache.hadoop.conf.Configuration; 

public class TemperatureMaxMin { 

	
	// Mapper 
	
	/*MaxTemperatureMapper class is static 
	* and extends Mapper abstract class 
	* having four Hadoop generics type 
	* LongWritable, Text, Text, Text. 
	*/
	
	
	public static class MaxTemperatureMapper extends
			Mapper<LongWritable, Text, Text, Text> { 
		
		/** 
		* @method map 
		* Method ini mendapatkan input dari sebuah text file.
		* Lupakan 5 kolom/token pertama, karena yang diambil hanya 
		* kolom/token nomor 6 sebagai suhu maksimumnya, dan 
		* kolom/token nomor 7 sebagai suhu minimumnya.  
		* Program ini akan menghasilkan output
		* jika suhu panas (lebih dari) > 30 and suhu dingin kurang dari 15 
		* dengan cara direduce. 
		*/

	// data kita akan diset ke value yang inconsistent data
	public static final int MISSING = 9999; 
		
	@Override
		public void map(LongWritable arg0, Text Value, Context context) 
				throws IOException, InterruptedException { 

		// Mengkonversikan sebuah baris/Record ke
		// String and disimpan juga ke dalam String 
		// nama variabel nya adalah : line 
			
		String line = Value.toString(); 
			
			// Melakukan pengecekan kondisi jika baris/Record tersebut kosong. 
			if (!(line.length() == 0)) { 
				
				// dari karakter 6 - 14 adalah tanggal pada dataset yang
				// kita miliki.
				String date = line.substring(6, 14); 
				
				// Pertama, kita harus men-set suhu maximum nya dari 
				// karakter 39 to 45. 
				float temp_Max = Float.parseFloat(line.substring(39, 45).trim()); 
				
				// Selanjutnya kita set suhu minimum nya dari  
				// karakter 47 - 53. 
				float temp_Min = Float.parseFloat(line.substring(47, 53).trim()); 

				// jika suhu maximum nya lebih dari 30, maka 
				// hari tersebut sedang bercuaca panas (hot day).
				if (temp_Max > 30.0) { 
					// Cuaca panas
					context.write(new Text("Hari dengan Cuaca yang Panas:" + date), 
										new Text(String.valueOf(temp_Max))); 
				} 

				// jika suhu minimumnya kurang dari 15 derajat, 
				// maka hari tersebut sedang bercuaca dingin.
				if (temp_Min < 15) { 
					// Cuaca dingin 
					context.write(new Text("Hari dengan Cuaca yang Dingin :" + date), 
							new Text(String.valueOf(temp_Min))); 
				} 
			} 
		} 

	} 

	//Reducer 
	
	/*MaxTemperatureReducer class is static 
	and extends Reducer abstract class 
	having four Hadoop generics type 
	Text, Text, Text, Text. 
	*/
	
	public static class MaxTemperatureReducer extends
			Reducer<Text, Text, Text, Text> { 

		/** 
		* @method reduce 
		* Method ini menjadikan input file sebagai key dan list dari   
		* pasangan nilai yang dihasilkan oleh method mapper, 
		* ini akan melakukan proses penyatuan berdasarkan dari keys, and 
		* akan menghasilkan konteks akhir. 
		*/
		
		public void reduce(Text Key, Iterator<Text> Values, Context context) 
				throws IOException, InterruptedException { 

			
			// meletakkan semua value nya ke dalam
			// temperature variabel sebagai tipe data String. 
			String temperature = Values.next().toString(); 
			context.write(Key, new Text(temperature)); 
		} 

	} 

	/** 
	* @method main 
	* Method ini digunakan untuk melakukan penyettingan dan 
	* melakukan konfigurasu untuk semua property. 
	* Method ini juga bekerja sebagai driver terhadap kode 
	* map-reduce yang kita buat. 
	*/
	
	public static void main(String[] args) throws Exception { 

		// membaca konfigurasi default dari file cluster 
		// dari konfigurasi XML Files.
		Configuration conf = new Configuration(); 
		
		// Inisialisasi Job dengan konfigurasi default 
		// pada file cluster.
		Job job = new Job(conf, "weather example"); 
		
		// Memberikan nama untuk kelas driver.  
		job.setJarByClass(TemperatureMaxMin.class); 

		// tipe key yang keluar dari mapper. 
		job.setMapOutputKeyClass(Text.class); 
		
		// value yang keluar dari mapper.
		job.setMapOutputValueClass(Text.class); 

		// mendefinisikan nama untuk kelas Mapper. 
		job.setMapperClass(MaxTemperatureMapper.class); 
		
		// Mendefinisikan nama untuk kelas Reducer.
		job.setReducerClass(MaxTemperatureReducer.class); 

		// Mendefinsikan nama kelas untuk input format yang dimana 
		// merespon perubahan dari dataset ke dalam 
		// sebuah pasangan key (keys pair).
		job.setInputFormatClass(TextInputFormat.class); 
		
		// Mengkonversi nama kelas untuk output format yang dimana
		// merespon perubahan dari dataset ke dalam
		// pasangan key-value.
		job.setOutputFormatClass(TextOutputFormat.class); 

		// mengatur argumen kedua sebagai path di dalam sebuah  
		// path variable 
		Path OutputPath = new Path(args[1]); 

		// Konfigurasi letak input dari filesystem ke dalam Job.  
		FileInputFormat.addInputPath(job, new Path(args[0])); 

		// Mengatur letak output dari filesystem ke dalam Job. 
		FileOutputFormat.setOutputPath(job, new Path(args[1])); 

		// Menghapus lokasi konteks secara otomatis 
		// dari HDFS, Jadi kita tidak perlu lagi 
		// untuk menghapusnya kembali.
		OutputPath.getFileSystem(conf).delete(OutputPath); 

		// Keluar dari Job hanya jika kondisinya adalah False.
		System.exit(job.waitForCompletion(true) ? 0 : 1); 

	} 
} 

