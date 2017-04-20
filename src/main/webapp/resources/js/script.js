
$(document).ready(function () {
    $("#chb").click(function () {
        if ($('#chb').is(':checked')){
            $('#turn').show();
        }
        if (!$('#chb').is(':checked')){
            $('#turn').hide();
        }

    });
});