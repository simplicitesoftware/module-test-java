var TestJavaSignature = (function() {

	function render(params) {
		var sp = new SignaturePad(document.getElementById('signature-pad'), { backgroundColor: 'rgb(255, 255, 255)' });

		$("#signature-save").click(function() {
			var d = sp.toDataURL('image/png');
			$("#signature").append($("<img/>", { src: d }));
		});
	}

	return {
		render: function(params) {
			if (typeof SignaturePad === "undefined") {
				$ui.loadScript({
					url: "https://cdn.jsdelivr.net/npm/signature_pad@2.3.2/dist/signature_pad.min.js",
					onload: function() { render(params); }
				});
			} else {
				render(params);
			}
		}
	};

})();