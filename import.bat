

set user=%1
set password=%2
set ip=%3
set dataBaseDump=%4

set sqlQuery="USE inmobiliaria;SOURCE %dataBaseDump%;"

set sqlPath="C:\Program Files\MySQL\MySQL Server 5.7\bin\

%sqlPath%mysql.exe" -u %user% --password=%password% -h %ip% --execute=%sqlQuery%
