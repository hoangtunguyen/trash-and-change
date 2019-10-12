var urlAPI = "10.10.255.176:8080";
var arrMarker=[];
var lastClickMarker =  null;
// var infowindow = null;
var map;
$( document ).ready(function() {
    let windowHeight = $(window).outerHeight(true);
    let top_nav = $(".topnav").outerHeight(true);
    let searcHeight = $("#search").outerHeight(true);
    let heightList = windowHeight - top_nav - searcHeight;
    $(".container-box").height(heightList);
    console.log(heightList);

});
function getStoresInMap() {

    setTimeout(() => {
        $.ajax({
            type : "GET",
            async: false,
            url : "/getAllStores",
            contentType: 'application/json',
            mimeType: 'application/json',
            dataType : 'json',
            data: {},
            success : function(data) {
                let i = 0;
                map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 20,
                    center: {lat: 59.292241, lng: 18.003599}
                });

                $.each(data,function( key, value ) {
                    let marker = new google.maps.Marker({
                        map: map,
                        // draggable: true,
                        animation: google.maps.Animation.DROP,
                        position: {lat: value.lat, lng: value.lng}
                    });
                    arrMarker[i] = marker;
                    i++;
                });
                map.setCenter({lat: data[0].lat, lng: data[0].lng});
            },error: function(data){
            },

        });
    }, 100);
}

function initMap() {
    getStoresInMap();

}
$(function() {
    $(".container-box .card").on("click", function() {
        var index = $(this).index();
        toggleBounce(arrMarker[index]);
        map.setCenter(arrMarker[index].getPosition());

        let title =$("#title"+index).text();
        let name = $("#address"+index).text();
        let infor = {
            "title":title,
            "name" : name
        }
        descriptionStore(map,arrMarker[index],infor);
        $(".container-box").slideToggle();
    });

    $(".form-inline #search").click(function(){
        $(".container-box").slideToggle();
    });



});

function toggleBounce(marker) {
    if (lastClickMarker != null){
        lastClickMarker.setAnimation(null);
        lastClickMarker.infowindow.close();
    }
        marker.setAnimation(google.maps.Animation.BOUNCE);
        lastClickMarker = marker;
}

function descriptionStore(map,marker, obJInfor) {
    let infor = obJInfor;
    let contentString = '<div id="content">'+
        '<div id="siteNotice">'+
        '</div>'+
        '<h6 id="firstHeading" class="firstHeading">'+infor["title"]+'</h6>'+
        '<div id="bodyContent">'+
        '<p><b>'+infor["name"]+'</b></p>'+
        '</div>'+
        '</div>';

    marker.infowindow = new google.maps.InfoWindow({
        content: contentString
    });

    marker.infowindow.open(map, marker);

    lastClickMarker = marker;
}

