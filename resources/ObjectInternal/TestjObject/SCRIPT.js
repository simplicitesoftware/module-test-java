(function() {
	Simplicite.UI.hooks.TestjObject = function(o, cbk) {
		try {
			if (o.isMainInstance()) {
				o.locals.ui.form.onload = function(ctn, obj) {
					$ui.getUIField(ctn, obj, "testjObjDocumentURL").ui.input.closest(".input-group")
						.append($('<span class="input-group-addon pointer" data-action="TestjObjectUpload"/>').append($ui.view.icon("fas/upload"))
						.click(function() {
						$ui.getUIField(ctn, obj, "testjObjDocument").ui.visible(Simplicite.VIS_FORM);
					}));
				};
			}
		} catch(e) {
			app.error("Error in Simplicite.UI.hooks.TestjObject: "+e.message);
		} finally {
			cbk && cbk();
		}
	};
})();