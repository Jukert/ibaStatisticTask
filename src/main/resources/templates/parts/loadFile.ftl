<form action="/file" method="post" enctype="multipart/form-data">
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
        </div>
        <div class="custom-file">
            <input type="file" name="loadFile" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
            <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
        </div>
    </div>

    <div class="well">
        <div id="datetimepicker1" class="input-append date">
            <input data-format="dd/MM/yyyy hh:mm:ss" name="date" type="text"></input>
            <span class="add-on">
                <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
            </span>
        </div>
    </div>
    <button >Load</button>
</form>