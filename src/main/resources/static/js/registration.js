$(document).ready(function () {
    $('#registrationButton').on('click', function (event) {
        event.preventDefault();
        registrOfNewUser();
    })
});

function registrOfNewUser() {
    $('#registrationButton').on('click', function (event) {
        event.preventDefault();

        let registrationForm = {
            id: $('#addingId').val(),
            firstName: $('#firstName').val(),
            secondName: $('#lastName').val(),
            email: $('#username').val(),
            password: $('#password').val(),
            // passwordConfirmation: $('#passwordConfirmation').val()
        }

        $.ajax({
            url: '/api/registration',
            type: 'POST',
            data: JSON.stringify(registrationForm),
            contentType: "application/json",
            success: function () {
                window.location.replace("/login");
                alert('User has been registred successfully');
            },
            error: function () {
                alert('Registration Error');
            }
        })
    })
}
