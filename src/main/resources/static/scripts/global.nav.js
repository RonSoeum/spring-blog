"use strict";

$(document).ready(() => {

    $('.nav-link-toggle').click(() => {
        $('.nav-items').toggleClass('nav-toggle-show');
    });

    $(function() {
        $('.nav-items a[href^="/' + location.pathname.split("/")[1] + '"]').addClass('active');
    });

});// Ready