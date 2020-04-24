$(document).ready(function() {
    var contentLimit = 100;
    var refreshInterval = 300000;
    var url = location.protocol + "//" + location.host + location.pathname;

    var displayLastUpdate = function() {
        var lastUpdateDiv = $("#last-update-div");

        lastUpdateDiv.append("<p>Last update: " + new Date() + "</p>");
    };

    var refreshDataId = setInterval(function() {
        location.reload();
    }, refreshInterval);

    $("#content-limit-button").click(function(e) {
        e.preventDefault();

        var rawInput = $("#content-limit-input").val();
        var parsedInput = parseInt(rawInput);
        var inputErrorP = $("#input-error-p");

        inputErrorP.empty();

        if (isNaN(parsedInput) || parsedInput <= 0 || parsedInput > 1000) {
            inputErrorP.append("INPUT ERROR: Please input an integer between 1 and 1000.");
        } else {
            clearInterval(refreshDataId);

            contentLimit = parsedInput;
            url += "?limit=" + contentLimit;
            location.href = url;

            refreshDataId = setInterval(function() {
                location.reload();
            }, refreshInterval);
        }
    });

    displayLastUpdate();
});