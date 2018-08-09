// Domestic:true  Overseas: false
var $location = true

// Individual:true  Company: false
var $idType = true;

// 初始
$(document).ready(function() {
    checkSelected();
    $('.location__item').on('click', clickLocationItem);
    $('.login__id__item').on('click', clickIdItem);
});


function clickLocationItem(event) {
    // 判斷國內還是海外
    if ($(this).hasClass('login__id__item--domestic')) {
        $location = true;
        // console.log($(this));
    } else {
        $location = false;
        // console.log($(this));
    }
    checkSelected();
}

function clickIdItem(event) {
    // 判斷是個人還是公司
    if ($(this).hasClass('login__id__item--presonal')) {
        $idType = true;
        // console.log($(this));
    } else {
        $idType = false;
        // console.log($(this));
    }
    checkSelected();
}


function checkSelected() {
    $('.location__item').removeClass('login__id__item--selected');

    if ($location == true) {
        $('.login__id__item--domestic').addClass('login__id__item--selected');
        // $("#NextLink").attr("href","create_personal.html");
    } else {
        $('.login__id__item--overseas').addClass('login__id__item--selected');
        // $("#NextLink").attr("href","create_company.html");
    }

    $('.login__id__item').removeClass('login__id__item--selected');
    $("#Remind").find('.warn--left').removeClass('remind--hide');


    if ($idType == true) {
        $('.login__id__item--presonal').addClass('login__id__item--selected');
        $("#Remind").find('.remind--bn').addClass('remind--hide');
        // $("#NextLink").attr("href", "create_personal.html");
    } else {
        $('.login__id__item--company').addClass('login__id__item--selected');
        $("#Remind").find('.remind--id').addClass('remind--hide');
        // $("#NextLink").attr("href", "create_company.html");
    }

}