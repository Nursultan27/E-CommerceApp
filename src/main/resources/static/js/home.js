$(document).ready(function () {
    $.ajax({
        url: '/api/books',
        type: 'GET',
        dataType: 'json',
        success: function (listOfBooks) {
            $.each(listOfBooks, function (i, book) {
                let output =
                    '<div class="card m-2" style="width: 17rem;">' +
                        '<img src="' + book.imageUrl + '" class="img-fluid" style="width: 15rem; height: auto; align-self: center;" class="card-img-top" alt="*">' +
                        '<div class="card-body text-center">' +
                            '<h5 class="card-title">' + book.name + '</h5>' +
                        '</div>' +
                        // '<div class="card-body">' +
                        //     book.description +
                        // '</div>' +
                        '<div class="card-footer">' +
                            '<div class="d-flex flex-row justify-content-between align-items-center">' +
                                '<div class="price m-0">' + book.unitPrice +'</div>' +
                                '<a href="#" class="primary-btn">Add to cart</a>' +
                            '</div>' +
                        '</div>' +
                    '</div>';
                $('.product-box').append(output);
            });
        },
        error: function () {
            alert("BooksError");
        }
    })
})


