

set user=%1
set password=%2
set ip=%3
set dataBaseDump=%4

set sqlQuery="USE inmobiliaria;SOURCE %dataBaseDump%;"

set sqlPath="C:\%programfiles(x86)%\MySQL\MySQL Server 5.5\bin\

%sqlPath%mysql.exe" -u %user% --password=%password% -h %ip% --execute=%sqlQuery%
