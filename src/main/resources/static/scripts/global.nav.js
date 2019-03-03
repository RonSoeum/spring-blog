"use strict";

$(document).ready(() => {

    $('.nav-link-toggle').click(() => {
        $('.nav-items').toggleClass('nav-toggle-show');
    });

    $(function() {
        if (location.pathname !== "/") {
            $('.nav-link a[href^="/' + location.pathname.split("/")[1] + '"]').addClass('active');
            $('.nav-link a[href^="/posts/create"]').removeClass('active');
            if (location.pathname === "/posts/create") {
                $('.nav-link a[href^="/posts"]').removeClass('active');
                $('.nav-link a[href^="/posts/create"]').addClass('active');

            }
        }
    });

});// Ready