<!DOCTYPE html>
<html>
<body>
    <#if savePath?? > ${savePath}</#if>
    <form method="POST" enctype="multipart/form-data"
          action="/file/upload">
        File to upload: <input type="file" name="file"><br />
        Name: <input type="text" name="name">
        <br />
        <br />
        <input type="submit" value="Upload"> Press here to upload the file!
    </form>
</body>
</html>