$(function(){
    $("#addTabeleLine").on("click",function(){
        $("#estimatesTable").append(function(){
            var tableLine = "<tr><td><i class='fas fa-bars'></i></td>";
            var itemsCount = 8;
            for(var i = 0;i < itemsCount; i++){
                tableLine += "<td></td>";
            }
            tableLine += "</tr>";
            return tableLine;
        });
    });
});