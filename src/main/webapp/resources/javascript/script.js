$(document).ready(function(){
    
        $(window).scroll(function(event){
            var y = $(this).scrollTop();
            console.log(y);
                                   
            if(y >= 100){
                    $('#w0, #w2').removeClass('navbar-fixed-top');
                    $('#w2').removeClass('navbar-fixed-top');
                    $('.wrap > .container').css('paddingTop','0px');
            }
            if(y < 100){
                    $('#w0, #w2').addClass('navbar-fixed-top');
                    $('#w2').addClass('navbar-fixed-top');
                    $('.wrap > .container').css('paddingTop','115px');
            }

        });
    
});
