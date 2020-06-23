$(document).ready(function () {
    $.ajax({
        url: '/api/books',
        type: 'GET',
        dataType: 'json',
        success: function (listOfBooks) {
            let bookData = '';
            $.each(listOfBooks, function (i, book) {
                bookData += ('<a href="product-detail.html">');
                bookData += ('<img src=/images/books/' + book.imageURL + 'class="img-responsive">');
                bookData += ('</a>');
                bookData += ('<a href="product-detail.html">');
                bookData += ('<h1>' + book.name + '</h1>');
                bookData += ('</a>');
                // bookData += ('<h2>' + book.description + '</h2>');
                bookData += ('<div class="price">' + book.unitPrice +'</div>');
                bookData += ('<a href="#" class="primary-btn">Add to cart</a>\n');
                bookData += ('');

                $('.product-box').html(bookData);

            });

        },
        error: function () {
            alert("BooksError");
        }
    })
})


