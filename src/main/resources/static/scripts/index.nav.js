"use strict";

$(document).ready(() => {

    $(document).scroll(function () {
        let $navbar = $('.navbar');
        let $navItems = $('.nav-items a');
        let $navLogo = $('.nav-logo a');
        let $navItemsActive = $('.nav-items a.active');
        let $navLogoActive = $('.nav-logo a.active');
        let $sec1 = $('.sec1');
        $navbar.toggleClass('scrolled', $(this).scrollTop() > $sec1.height());
        $navItems.toggleClass('scrolld', $(this).scrollTop() > $sec1.height());
        $navLogo.toggleClass('scrolld', $(this).scrollTop() > $sec1.height());
        $navItemsActive.toggleClass('scroll', $(this).scrollTop() > $sec1.height());
        $navLogoActive.toggleClass('scroll', $(this).scrollTop() > $sec1.height());
    });

    $(function() {
        $('.nav-logo a[href^="/' + location.pathname.split("/")[1] + '"]').addClass('active');
    });

});// Ready