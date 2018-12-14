<form action="/file" class="fileLoader" method="post" enctype="multipart/form-data">
    <h1>Load statistic specificFile</h1>
    <#if message??>
        <div class="alert alert-danger" role="alert">${message}</div>
    </#if>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
        </div>
        <div class="custom-file">
            <input type="file" name="loadFile" class="custom-file-input" id="inputGroupFile01"
                   aria-describedby="inputGroupFileAddon01">
            <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
        </div>
    </div>

    <div class="input-group mb-2">
        <div class="input-group-prepend">
            <div class="input-group-text" data-toggle="tooltip" data-placement="top" title="Time specificFile destroing">
                date/time
            </div>
        </div>
        <input type="text" class="form-control" placeholder="2018-12-03" name="date" id="datepicker">
        <input type="time" name="time" class="form-control" id="inlineFormInputGroup" placeholder="Username">
    </div>
    <button class="btn btn-primary btn-lg btn-block">Load</button>
</form>