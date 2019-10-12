function initMap() {

    setTimeout(() => {
        let id = Number(document.location.href.split("=")[1]);
        $.ajax({
            type : "GET",
            async: false,
            url : "/getDetailStore?id="+id,
            contentType: 'application/json',
            mimeType: 'application/json',
            dataType : 'json',
            data: {},
            success : function(data) {
                map = new google.maps.Map(document.getElementById('map_storeDetail'), {
                    zoom: 13,
                    center: {lat: data.lat, lng: data.lng}
                });
                    let marker = new google.maps.Marker({
                        map: map,
                        // draggable: true,
                        animation: google.maps.Animation.DROP,
                        position: {lat: data.lat, lng: data.lng}
                    });
            },error: function(data){
            },

        });
    }, 100);
}