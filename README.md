# Tutorial 2

URL aplikasi: https://eshop-tutorial-jteo0.koyeb.app/
# Tutorial 1
<b>Reflection 1</b></br>
Saya sudah melihat kembali source code saya dan mengedit semua bagian agar mengikuti prisip clean coding. Semua variabel, method, dan class memiliki nama yang jelas dan <i>straight to the point</i>, dan semua method hanya melakukan satu hal. Sebagai contoh, variabel untuk method yang berfungsi untuk mengedit Product sudah dibuat hanya dinamakan <code>edit</code> karena sudah jelas apa yang akan diubah. Selain itu, saya menerapkan method <code>delete</code> dengan menggunakan method lain yang mengembalikan Product berdasarkan ID, dan method itu digunakan delete untuk mencari Produk yang harus dihapus dari list repository. Saya juga menghindari penggunaan komentar dan lebih berfokus untuk membuat kode saya lebih intuitif. Untuk error-handling, saya sudah membuat test untuk edit dan delete, namun saya mengaku bahwa ada kemungkinan sesuatu yang kurang di bagian itu (mungkin ada case yang saya lupa memikirkan). 
<p></p>
<b>Reflection 2</b></br>
Setelah membuat unit test, saya merasa agak kewalahan karena harus memikirkan scenario semua scenario berbeda yang mungkin terjadi dan cara untuk mengetesnya dengan menggunakan jumlah tes yang paling sedikit.
<p></p>
Untuk membuat functional test suite untuk verifikasi jumlah Product di product list, menurut saya prosedur dan instance variable yang digunakan tidak terlalu beda. Di CreateProductFunctionalTest.java, proses setup dan pembuatan produk sama. Perbedaannya adalah di CreateProductFunctionalTest.java tesnya hanya meliputi interaksi user dengan program (contohnya pengeklikan submit dalam pembuatan produk) dan functional test suite yang hipotetis ini memiliki fokus untuk verifikasi jumlah produk (contohnya setelah ada pembuatan, delete, atau edit). Ini berarti bahwa kedua test suite memiliki banyak overlap dan bisa dibuat menjadi lebih efektif ('clean'). Menurut saya, kedua functional test suite bisa digabung menjadi satu file atau bagian yang overlap dibuat menjadi method sendiri yang kemudian digunakan di kedua file.
