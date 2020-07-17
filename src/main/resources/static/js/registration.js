$(document).ready(function () {
    $('#registrationButton').on('click', function (event) {
        event.preventDefault();
        registerNewUser();
    })
});

function registerNewUser() {
    $('#registrationButton').on('click', function (event) {
        event.preventDefault();

        let registrationForm = {
            firstName: $('#firstName').val(),
            lastName: $('#lastName').val(),
            email: $('#username').val(),
            password: $('#password').val(),
            // passwordConfirmation: $('#passwordConfirmation').val()
        }

        $.ajax({
            url: '/api/registration',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify(registrationForm),

            success: function () {
                window.location.replace("/login");
                alert('User has been registered successfully');
            },
            error: function () {
                alert('Registration Error');
            }
        })
    })
}
