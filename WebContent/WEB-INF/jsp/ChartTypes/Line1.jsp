<%@ page import="java.util.*" %>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>

<div id='chartContainer'></div>

<script type="text/javascript">
    dataPoints =${dataPoints}
    $(function () {
        var chart = new CanvasJS.Chart("chartContainer", {
            theme: "light2",
            zoomEnabled: true,
            animationEnabled: true,
            title: {
                text: "Memeory Usage"
            },
            subtitles: [
                {
                    text: ""
                }
            ],
            data: [{
                    type: "line",
                    dataPoints: dataPoints
                }]
        });
        chart.render();
    });
</script>