"use strict";

$(document).ready(() => {

    $(document).scroll(function () {
        let $navbar = $('.navbar');
        let $navItems = $('.nav-items a');
        let $navItemsActive = $('.nav-items a.active');
        let $sec1 = $('.sec1');
        $navbar.toggleClass('scrolled', $(this).scrollTop() > $sec1.height());
        $navItems.toggleClass('scrolld', $(this).scrollTop() > $sec1.height());
        $navItemsActive.toggleClass('scroll', $(this).scrollTop() > $sec1.height());
    });

    $('.nav-link-toggle').click(() => {
        $('.nav-items').toggleClass('nav-toggle-show');
    });

});// Ready