var TestJavaChartJS = (function() {
	function chart(params) {
		console.log(params);
		var p = params.parameters;
		if (p.object)
			console.log("Called from " + p.object + " (row ID " + p.row_id + ")");
		try {
			new Chart(document.getElementById("testjavachartjs-chart"), {
				type: 'line',
				data: {
					labels: [1,2,3,4,5,6,7,8,9,10],
					datasets: [{ 
						data: [168,170,178,190,203,276,408,547,675,734],
						label: "Serie 1",
						borderColor: "#3e95cd",
						fill: false
					}, { 
						data: [6,3,2,2,7,26,82,172,312,433],
						label: "Serie 2",
						borderColor: "#8e5ea2",
						fill: false
					}]
				},
				options: {
					title: {
						display: true,
						text: "Chart.js example"
					}
				}
			});
		} catch(e) {
			app.error(e);
		}
	}

	return {
		render: function(params) {
			$ui.loadCharts(function() { chart(params); });
		}
	};
})();
