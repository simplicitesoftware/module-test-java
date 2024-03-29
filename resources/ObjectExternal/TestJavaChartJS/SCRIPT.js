var TestJavaChartJS = (function() {

	function displayChart(spec) {
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

	function callChart(url, prm) {
		$ui.loadCharts(function() {
			$.ajax({
				url: url,
				method: "post",
				dataType: "json",
				data: prm
			}).done(function(spec) {
				displayChart(spec);
			}).fail(function(status, err) {
				$("testjavachartjs").text("Error: status = " + status + ", message = " + err.message);
			})
		});
	}

	return {
		render: function(params) {
			var url = params.baselocation;
			var prm = params.parameters;
			if (prm.object && prm.inst && prm.row_id) {
				$ui.getUIObject(prm.object, prm.inst, function(obj) {
					var start = obj.item.testjObj1Start;
					if (start >= 0) prm.start = start;
					var inc = obj.item.testjObj1Inc;
					if (inc >= 0) prm.inc = inc;
					callChart(url, prm);
				});
			} else {
				callChart(url, prm);
			}
		}
	};

})();
