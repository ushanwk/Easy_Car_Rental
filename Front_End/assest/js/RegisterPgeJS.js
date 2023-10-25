$('#step1').show();
$('#step2').hide();
$('#step3').hide();

$('#btnNext1').click(function (){
    $('#step1').hide();
    $('#step2').show();
    $('#step3').hide();
});

$('#btnNext2').click(function (){
    $('#step1').hide();
    $('#step2').hide();
    $('#step3').show();
});

