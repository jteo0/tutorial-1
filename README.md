# Tutorial 3
1.</br>
Principle SOLID yang berlaku:</br>
 - Single Responsibility Principle (SRP): SRP adalah prinsip dimana setiap class hanya memiliki satu tugas/<i>responsibility</i>. Ini berarti bahwa di satu class, sebaiknya  memiliki satu tanggung jawab dan berisi hanya dengan satu hal/beberapa hal yang memiliki fungsi yang berdekatan. Pada kode saya, ini diterapkan dengan memisahkan file CarController menjadi filenya sendiri.</br>
 - Open-Closed Principle (OCP): OCP adalah prinsip dimana tertulis bahwa kode harus bersifat '<i>open for extension but closed for modification</i>'. Ini berarti bahwa suatu kode harus terbuka untuk di extend/dipakai kode lain, tetapi tidak secara langsung dengan dimodifikasi. Pada kode saya, ini diterapkan pada folder controller. Sebagai contoh, CarController mengextend ProductController. CarController menambahkan mapping untuk aplikasi tanpa mengubah ProductController.</br>
 - Liskov Substitute Principle (LSP): LSP adalah prinsip dimana suatu class dan superclassnya harus memiliki behavior yang serupa (<i>as to be interchangable</i>). Pada kode saya, ini diterapkan pada CarController dan ProductController. Keduanya memiliki fungsi yang berdekatan (create, edit, delete, dll) dan secara keseluruhan memiliki behavior yang sama.</br>
 - Interface Segregation Principle (ISP): ISP adalah prinsip dimana interface dipisah (segregate) menjadi bagian seperlunya yang spesifik. Pada kode saya, ini bisa dilihat pada ProductServiceImpl dan CarServiceImpl. Kedua interface tersebut dipisah karena walaupun memiliki method yang berdekatan dalam fungsi, secara praktek, methodnya hanya berlaku untuk product dan car masing-masing.</br>
 - Dependency Inversion Principle (DIP): DIP adalah prinsip dimana suatu class sebaiknya memiliki dependency terhadap interface atau abstract class daripada concrete class. Pada kode saya, ini bisa dilihat dari ProductController dan CarController, dimana keduanya mereference interface ProductService dan CarService.</br>

<p>2.</br>
Keunggulan penerapan prinsip SOLID (contoh pada kode saya ada di soal pertama):</br>
 - Kode menjadi lebih mudah untuk dipahami orang lain (semua bagian kode memiliki fungsi yang jelas, dan juga lebih mudah untuk dibaca).</br>
 - Memudahkan proses testing dan debugging.</br>
 - Kode menjadi lebih mudah untuk discale dan lebih fleksibel.</p>

<p>3. </br>
Kekurangan dari tidak menerapkan prinsip SOLID:</br>
 - Ada risiko lebih tinggi munculnya bug akibat dari perubahan ke kode yang sudah benar.</br>
 - Bug yang muncul lebih susah untuk dicari, karena yang dimodifikasi bisa dibagian mana saja dari kode.</br>
 - Kodenya kurang intuitif. Diperlukan waktu yang lebih lama untuk mengertinya (belum tentu masuk akal bagi orang lain juga).
</p>

# Tutorial 2
1.</br>
Code quality issues:</br>
 - Unused imports: Saya hapus import yang tidak digunakan dalam file.</br>
 - JUnit test classes and methods should have default class visibility: Menghapus 'public' didepan class test JUnit.
<p>2.</br>
Menurut saya, workflow CI/CD yang saya implementasi sudah memenuhi definisi CI/CD. Bagian CI atau <i>Continuous Integration</i> adalah practice dimana proses testing dilakukan secara otomatis. Pada aplikasi ini, testing akan otomatis berjalan setelah setiap push. Bagian CD atau <i>Continuous Deployment</i> adalah practice dimana proses deployment aplikasi dilakukan secara otomatis. Untuk aplikasi ini, deployment di automasi sehingga setiap kali push, aplikasi akan redeploy menggunakan Koyeb.
</p>


URL aplikasi: https://eshop-tutorial-jteo0.koyeb.app/
# Tutorial 1
<b>Reflection 1</b></br>
Saya sudah melihat kembali source code saya dan mengedit semua bagian agar mengikuti prisip clean coding. Semua variabel, method, dan class memiliki nama yang jelas dan <i>straight to the point</i>, dan semua method hanya melakukan satu hal. Sebagai contoh, variabel untuk method yang berfungsi untuk mengedit Product sudah dibuat hanya dinamakan <code>edit</code> karena sudah jelas apa yang akan diubah. Selain itu, saya menerapkan method <code>delete</code> dengan menggunakan method lain yang mengembalikan Product berdasarkan ID, dan method itu digunakan delete untuk mencari Produk yang harus dihapus dari list repository. Saya juga menghindari penggunaan komentar dan lebih berfokus untuk membuat kode saya lebih intuitif. Untuk error-handling, saya sudah membuat test untuk edit dan delete, namun saya mengaku bahwa ada kemungkinan sesuatu yang kurang di bagian itu (mungkin ada case yang saya lupa memikirkan). 
<p></p>
<b>Reflection 2</b></br>
Setelah membuat unit test, saya merasa agak kewalahan karena harus memikirkan scenario semua scenario berbeda yang mungkin terjadi dan cara untuk mengetesnya dengan menggunakan jumlah tes yang paling sedikit.
<p></p>
Untuk membuat functional test suite untuk verifikasi jumlah Product di product list, menurut saya prosedur dan instance variable yang digunakan tidak terlalu beda. Di CreateProductFunctionalTest.java, proses setup dan pembuatan produk sama. Perbedaannya adalah di CreateProductFunctionalTest.java tesnya hanya meliputi interaksi user dengan program (contohnya pengeklikan submit dalam pembuatan produk) dan functional test suite yang hipotetis ini memiliki fokus untuk verifikasi jumlah produk (contohnya setelah ada pembuatan, delete, atau edit). Ini berarti bahwa kedua test suite memiliki banyak overlap dan bisa dibuat menjadi lebih efektif ('clean'). Menurut saya, kedua functional test suite bisa digabung menjadi satu file atau bagian yang overlap dibuat menjadi method sendiri yang kemudian digunakan di kedua file.
