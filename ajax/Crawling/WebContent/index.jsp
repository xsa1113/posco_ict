<%@page import="MovieDatas.MovieChart"%>
<%@page import="dto.MovieVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	List<MovieVo> list = MovieChart.getCGVdata();
	for(MovieVo v : list){
		System.out.println(v.toString());
	}
	
	// list -> json
	String jsonData = "[";
	for(MovieVo v : list){
		jsonData += "{ name:'" + v.getTitle() + "', y:" + v.getPercent() + "}," ;
	}
	jsonData = jsonData.substring(0, jsonData.lastIndexOf(","));
	
	jsonData += "]";
	
	System.out.println(jsonData);
	
	// 여기서 담으면 js에서 활용할 수 있다. 키값으로 통해서 
	request.setAttribute("jsonData", jsonData);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.highcharts-figure,
.highcharts-data-table table {
  min-width: 320px;
  max-width: 800px;
  margin: 1em auto;
}

.highcharts-data-table table {
  font-family: Verdana, sans-serif;
  border-collapse: collapse;
  border: 1px solid #ebebeb;
  margin: 10px auto;
  text-align: center;
  width: 100%;
  max-width: 500px;
}

.highcharts-data-table caption {
  padding: 1em 0;
  font-size: 1.2em;
  color: #555;
}

.highcharts-data-table th {
  font-weight: 600;
  padding: 0.5em;
}

.highcharts-data-table td,
.highcharts-data-table th,
.highcharts-data-table caption {
  padding: 0.5em;
}

.highcharts-data-table thead tr,
.highcharts-data-table tr:nth-child(even) {
  background: #f8f8f8;
}

.highcharts-data-table tr:hover {
  background: #f1f7ff;
}

input[type="number"] {
  min-width: 50px;
}
</style>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>

</head>

<body>

<figure class="highcharts-figure">
  <div id="container"></div>
  <p class="highcharts-description">
    Pie charts are very popular for showing a compact overview of a
    composition or comparison. While they can be harder to read than
    column charts, they remain a popular choice for small datasets.
  </p>
</figure>

<script type="text/javascript">
Highcharts.chart('container', {
	  chart: {
	    plotBackgroundColor: null,
	    plotBorderWidth: null,
	    plotShadow: false,
	    type: 'pie'
	  },
	  title: {
	    text: '2022.05.27 movie chart'
	  },
	  tooltip: {
	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	  },
	  accessibility: {
	    point: {
	      valueSuffix: '%'
	    }
	  },
	  plotOptions: {
	    pie: {
	      allowPointSelect: true,
	      cursor: 'pointer',
	      dataLabels: {
	        enabled: true,
	        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	      }
	    }
	  },
	  series: [{
	    name: 'Brands',
	    colorByPoint: true,
	    data: <%=request.getAttribute("jsonData")%>
	  }]
	});

</script>



</body>
</html>