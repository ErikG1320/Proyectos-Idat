$(window).on('load', function () {
    const imageCount = $("#slider ul li").length;
    const imagewidth = $("#slider ul li:first img").width();
    const TotalWidht = (imageCount * imagewidth) + "px"; // Corregido: añadida comilla

    let leftposition = 0;
    let counter = 0;

    $("#slider ul").css({
        "width": TotalWidht // Corregido: propiedad "width"
    });

    $("#next").click(function () {
        counter++;
        if (counter >= imageCount) {
            counter = 0;
            leftposition = 0;
        }
        leftposition = `-${counter * imagewidth}px`; // Corregido: variable "imagewidth"
        $("#slider ul").animate({
            left: leftposition
        }, 500, "linear");
    });
    
    $("#previous").click(function () {
        counter--;
        if (counter < 0) {
            counter = imageCount - 1;
            leftposition = `-${(imageCount - 1) * imagewidth}px`;
        }
        leftposition = `-${counter * imagewidth}px`; 
        $("#slider ul").animate({
            left: leftposition
        }, 500, "linear");
    });
});
