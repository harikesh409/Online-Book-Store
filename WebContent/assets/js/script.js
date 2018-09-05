$(function () {
    $('input[type="text"],input[type="email"],input[type="password"],input[type="date"],input[type="number"],textarea,select').filter('[required]:visible').each(function () {
        $(this).prev("label").append('<span class="text-danger"> * </span>');
    });
});
