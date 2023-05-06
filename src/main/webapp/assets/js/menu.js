$(document).ready(function () {
    let url = window.location.pathname.split('/');
    $(".nav-link").filter('a[href="' + url[url.length - 1] + '"]').parent().addClass('active');
    $(".dropdown-item").filter('a[href="' + url[url.length - 1] + '"]').addClass('active');
});