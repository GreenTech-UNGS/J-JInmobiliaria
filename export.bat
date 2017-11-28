

set user=%1
set password=%2
set ip=%3
set toSavePath=%4

set sqlPath="C:\Program Files(x86)\MySQL\MySQL Server 5.7\bin\

%sqlPath%mysqldump.exe" --user=%user% --password=%password% -h %ip% inmobiliaria -r %toSavePath%