"use strict";

$(document).ready(() => {

    // $(document).scroll(function () {
    //     const $navbar = $('.navbar');
    //     const $navItems = $('.nav-items a');
    //     const $navLogo = $('.nav-logo a');
    //     const $navItemsActive = $('.nav-items a.active');
    //     const $navLogoActive = $('.nav-logo a.active');
    //     const $sec1 = $('.sec1');
    //     $navbar.toggleClass('scrolled', $(this).scrollTop() > $sec1.height()-60);
    //     $navItems.toggleClass('scrolld', $(this).scrollTop() > $sec1.height()-60);
    //     $navLogo.toggleClass('scrolld', $(this).scrollTop() > $sec1.height()-60);
    //     $navItemsActive.toggleClass('scroll', $(this).scrollTop() > $sec1.height()-60);
    //     $navLogoActive.toggleClass('scroll', $(this).scrollTop() > $sec1.height()-60);
    // });

    $(function() {
        $('.nav-logo a[href^="/' + location.pathname.split("/")[1] + '"]').addClass('active');
    });

    $('#link').click(function(e){
        const $target = $('html,body');
        const $sec1 = $('.sec1');
        $target.animate({scrollTop: $sec1.height()-50}, 800);
    });

});// Ready