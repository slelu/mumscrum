<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script type="text/javascript">
$(function () {
	var jsonTrend = JSON.parse("${Trend}");
	var jsonOriginalETC = JSON.parse("${OriginalETC}");
	var jsonRemainingTime = JSON.parse("${RemainingTime}");
	var jsonXAxis = JSON.parse('${DaysXAxis}'); 
    $('#container').highcharts({
        title: {
            text: 'Burn Down Chart',
            x: -20 //center
        },
        subtitle: {
            text: '${SprintName}',
            x: -20
        },
        xAxis: {
             categories: jsonXAxis 
           /*  categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'] */
        },
        yAxis: {
            title: {
                text: 'Effort'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: 'hour(s)'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
              /* series: [{
            name: 'Original Estimation',
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 86.5, 23.3, 18.3, 13.9, 9.6]
        }, {
            name: 'Remaining Time',
            data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]
        }, {
            name: 'Trend',
            data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]
        }]  */
        
        series: [{
            name: 'Trend/Ideal',
            data: jsonTrend
        }, {
            name: 'Original Estimation',
            data: jsonOriginalETC
        }, {
            name: 'Remaining Time',
            data: jsonRemainingTime
        }] 
    }); 
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

</body>
</html>