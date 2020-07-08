$(document).ready(function() {
    $("#do_login").click(function() {
        closeLoginInfo();
        $(this).parent().find('span').css("display","none");
        $(this).parent().find('span').removeClass("i-save");
        $(this).parent().find('span').removeClass("i-warning");
        $(this).parent().find('span').removeClass("i-close");

        var proceed = true;
        $("#login_form input").each(function(){

            if(!$.trim($(this).val())){
                $(this).parent().find('span').addClass("i-warning");
                $(this).parent().find('span').css("display","block");
                proceed = false;
            }
        });

        if(proceed) //everything looks good! proceed...
        {
            $(this).parent().find('span').addClass("i-save");
            $(this).parent().find('span').css("display","block");
            let form = $(getLogin("http://localhost:8080/login"));
            $('body').append(form);
            form.submit();

        }
    });

    //reset previously results and hide all message on .keyup()
    $("#login_form input").keyup(function() {
        $(this).parent().find('span').css("display","none");
    });

    openLoginInfo();
    setTimeout(closeLoginInfo, 1000);
});


function getLogin(url){
    let inputs = "";
    inputs += toInput("text", "login", document.getElementById('user').value);
    inputs += toInput("password", "password", document.getElementById('pass').value);
    return toForm(url, inputs);
}

function toInput(type, name, value){
    return '<input type=' + '"' + type + '" ' +
        'name=' + '"' + name + '" ' +
        'value=' + '"' + value + '"' +
        '/>';
}

function toForm(url, input){
    return '<form action=' + '"' + url + '" ' +'method="post">' + input + '</form>';
}

function openLoginInfo() {
    $(document).ready(function(){
        $('.b-form').css("opacity","0.01");
        $('.box-form').css("left","-37%");
        $('.box-info').css("right","-37%");
    });
}

function closeLoginInfo() {
    $(document).ready(function(){
        $('.b-form').css("opacity","1");
        $('.box-form').css("left","0px");
        $('.box-info').css("right","-5px");
    });
}

$(window).on('resize', function(){
    closeLoginInfo();
});