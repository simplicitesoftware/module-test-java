var TestJavaChartJS = (function() {

	function chart(spec) {
		try {
			new Chart(document.getElementById("testjavachartjs-chart"), {
				type: 'line',
				data: {
					labels: spec.labels,
					datasets: [{ 
						data: spec.data,
						label: spec.name,
						borderColor: "#3e95cd",
						fill: false
					}]
				},
				options: {
					title: {
						display: true,
						text: spec.title
					}
				}
			});
		} catch(e) {
			app.error(e);
		}
	}

	return {
		render: function(params) {
			$ui.loadCharts(function() {
				$.ajax({ url: params.baselocation, method: "post", dataType: "json", data: params.parameters }).done(function(spec) {
					chart(spec);
				}).fail(function(status, err) {
					$("testjavachartjs").text("Error: status = " + status + ", message = " + err.message);
				})
			});
		}
	};

})();
