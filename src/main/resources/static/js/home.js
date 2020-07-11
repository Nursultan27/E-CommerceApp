$(document).ready(function () {
    let page = 1;
    let amoutOfPagesForBooks = getAmoutOfPagesForBooks();

    //dynamic searching
    $('#search').on('keyup', function () {
        search();
    })


    loadPage(page);

    $('.au-btn-submit').on('click', function () {
        search();
    })

    $('#right').on('click', function () {
        loadPage(++page);
    })

    $('#left').on('click', function () {
        loadPage(--page);
    })

    $('#addC').on('click', function () {
        
    })

    function loadPage(page) {
        $.ajax({
            url: '/api/books',
            type: 'GET',
            dataType: 'json',
            data: 'page=' + page + '&size=' + 9,
            // contentType: String,
            success: function (listOfBooks) {
                $.each(listOfBooks, function (i, book) {
                    if (i == 0) {
                        $('.product-box').html(fillingBlockOfProduct(book))
                    } else {
                        $('.product-box').append(fillingBlockOfProduct(book))
                    }
                });
            }
        })
    }

    function search() {
        let search = $('#search').val();

        if (search != '') {
            $.ajax({
                url: '/api/search',
                type: 'GET',
                dataType: 'json',
                data: 'search=' + search,
                success: function (listOfDtoProducts) {
                    if (listOfDtoProducts.length == 0) {
                        $('.product-box').html('<h4 class="alert alert-warning col-md-12" role="alert"> No result found</h4>');
                    }

                    $.each(listOfDtoProducts, function (i, p) {
                        if (i == 0) {
                            $('.product-box').html(fillingBlockOfProduct(p))
                        } else {
                            $('.product-box').append(fillingBlockOfProduct(p))
                        }
                    })
                }
            })
        } else {
            loadPage(page);
        }
    }
})

function getAmoutOfPagesForBooks() {
    $.ajax({
        url: '/api/books/pages',
        type: 'GET',
        // dataType: Number,
        success: function (amoutOfPagesForBooks) {
            $('#pageNumber').html(amoutOfPagesForBooks / 10);
        },
        error: function () {
            alert("BooksError");
        }
    })
}

function fillingBlockOfProduct(book) {
    let output =
        '<div class="card m-2" style="width: 17rem;">' +
        '<img src="' + book.imageUrl + '" class="img-fluid" style="width: 15rem; height: auto; align-self: center;" class="card-img-top" alt="*">' +
        '<div class="card-body text-center">' +
        '<h5 class="card-title">' + book.name + '</h5>' +
        '</div>' +
        // '<div class="card-body">' +
        //     book.description +
        // '</div>' +
        // value="${book.id}"
        '<div class="card-footer">' +
        '<div class="d-flex flex-row justify-content-between align-items-center">' +
        '<div class="price m-0">' + book.unitPrice + '</div>' +
        '<button id="addC" class="btn btn-warning" type="submit">Add to cart</button>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '</div>';

    return output;
}