'Author Bharath Marrivada - mbr.reddy@gmail.com

'Arguments
Set objArgs = WScript.Arguments
Arg1 = objArgs(0)
Set objArgs = Nothing

'Email Invoked Y
Set wshShell = CreateObject( "WScript.Shell" )
Set wshSystemEnv = wshShell.Environment( "SYSTEM" )
'Set the environment variable
wshSystemEnv( "SeleniumEmailSentYN" ) = "Y"
ClientName = wshSystemEnv( "ClientName" )
TestCaseIDsList = wshSystemEnv( "TestCaseIDsList" )
FileNameCounter = wshSystemEnv( "FileNameCounter" )
FileName = wshSystemEnv( "FileName" )
Total = cInt(wshSystemEnv( "Total" ))
Pass = cInt(wshSystemEnv( "Pass" ))
Fail = cInt(wshSystemEnv( "Fail" ))
BatchTotal = cInt(wshSystemEnv( "BatchTotal" ))
BatchPass = cInt(wshSystemEnv( "BatchPass" ))
BatchFail = cInt(wshSystemEnv( "BatchFail" ))

If ClientName = Empty Then
	ClientName = "NoClientAssigned"
End If

If FileName = Empty Then
	FileName = ClientName & "_" & funGetTimeStamp()
	wshSystemEnv( "FileName" ) = FileName
	FileName = FileName & "__" & FileNameCounter
Else
	FileName = FileName & "__" & FileNameCounter
End If

If Arg1 = "c" then
	'MsgBox "Inside Wait"
	WScript.Sleep 30000 ' For TestNG to create reports
	FileName = FileName & "_Final"
	FileNameCounter = FileNameCounter & "_Final"
Else
End If

set fso=CreateObject("Scripting.FileSystemObject")
WorkingDirectory = fso.GetParentFolderName(Wscript.ScriptFullName)
'MsgBox WorkingDirectory

Set objEmailMessage = CreateObject("CDO.Message")
objEmailMessage.From = "XXXXXXXXXXXXXXXXXXXXX"


'*****Be careful with notifications********************************************************


objEmailMessage.To = "xxx@xxx.com"


'objEmailMessage.To = 


'objEmailMessage.Cc = 


'*****Be careful with notifications***********************************************************


objEmailMessage.Subject = IPAddress() & " - " & ClientName & " - TestResults - Batch:" & FileNameCounter

sMessage = sMessage & "Below are the executed test cases ID's" & VBCR & VBCR 
sMessage = sMessage & "All TC Executed  " & "Total:"& Total & "   " & "Pass:" & Pass & "   " & "Fail:" & Fail
sMessage = sMessage & VBCR
sMessage = sMessage & "This Batch:" & FileNameCounter & "   " & "Total:"& BatchTotal & "   " & "Pass:" & BatchPass & "   " & "Fail:" & BatchFail
sMessage = sMessage & VBCR & VBCR
sMessage = sMessage & TestCaseIDsList & VBCR
If Arg1 = "e" then
	sMessage =  VBCR & VBCR & sMessage & "Test not executed, some thing gone wrong!" & VBCR & VBCR
Else
End If
sMessage = sMessage & VBCR & VBCR
sMessage = sMessage & "Attachments contain TestNG report in HTML, Test log file and Failed test case screen shots." & VBCR
sMessage = sMessage & "All the test cases are broken into groups, due to some technical issues." & VBCR
sMessage = sMessage & "You will receive multiple email notification for the same client." & VBCR
sMessage = sMessage & "Executed System: " & IPAddress() & "   " & Now() & vbLf
sMessage = sMessage & VBCR & VBCR
sMessage = sMessage & "Regards," & vbLf
sMessage = sMessage & "QCTeam" & VBCR

objEmailMessage.TextBody = sMessage

objEmailMessage.Configuration.Fields.Item("http://schemas.microsoft.com/cdo/configuration/smtpserver") = "mail.global.frontbridge.com"
objEmailMessage.Configuration.Fields.Item("http://schemas.microsoft.com/cdo/configuration/smtpserverport") = 25
objEmailMessage.Configuration.Fields.Item("http://schemas.microsoft.com/cdo/configuration/sendusing") = 2
objEmailMessage.Configuration.Fields.Item("http://schemas.microsoft.com/cdo/configuration/smtpauthenticate") = 1
objEmailMessage.Configuration.Fields.Item("http://schemas.microsoft.com/cdo/configuration/smtpconnectiontimeout") = 20
objEmailMessage.Configuration.Fields.Item("http://schemas.microsoft.com/cdo/configuration/sendusername") = "XXXXXXXXX"
objEmailMessage.Configuration.Fields.Item("http://schemas.microsoft.com/cdo/configuration/sendpassword") = "XXXXXXXXX"

'Attach emailable report.html
objStartFolder = WorkingDirectory & "\Test_Reports\" 
ShowSubfolders fso.GetFolder(objStartFolder) ' Call sub 
'Attach Screenshots
Set folder = fso.GetFolder(WorkingDirectory & "\Screenshots\")
Set files = folder.Files
For each folderIdx In files
	objEmailMessage.AddAttachment(folderIdx)
Next

objEmailMessage.Configuration.Fields.Update

On Error Resume Next
objEmailMessage.Send      
         
If  err.number = 0 Then
   On Error Goto 0
   Set oNotepad = fso.createtextfile(WorkingDirectory & "\Screenshots\" & "EmailSentSuccessfully" & funGetTimeStamp()& ".txt")
   oNotepad.writeline("Email Sent Successfully")
   oNotepad.writeline funGetTimeStamp()
   oNotepad.Close
Else
   errNum = err.number
   errDesc = err.Description
   On Error Goto 0
   Set oNotepad = fso.createtextfile(WorkingDirectory & "\Screenshots\" & "EmailNOTSent" & funGetTimeStamp()& ".txt")
   oNotepad.writeline("EmailNOTSent")
   oNotepad.writeline("ErrorNumber:" & errNum)
   oNotepad.writeline("ErrorDesc:" & errDesc)
   oNotepad.writeline funGetTimeStamp()
   oNotepad.Close
End If

Set objEmailMessage = nothing

'***********************************************************************

MainFolder = "c:\Selenium2_Results\"
ModuleName = ClientName

TestResultsFolder = WorkingDirectory&"\Test_Reports\"
ScreenshotsFolder = WorkingDirectory&"\ScreenShots\"

BaseFolder = MainFolder&ModuleName&"\"

'Check base folder exist, else create new
If  Not fso.FolderExists(MainFolder) Then
   fso.CreateFolder (MainFolder)
End If

If  Not fso.FolderExists(MainFolder&ModuleName&"\") Then
   fso.CreateFolder (MainFolder&ModuleName&"\")
End If

'Check if folders are empty
set folder1 = fso.getFolder(TestResultsFolder)
Set folder1Sub = folder1.SubFolders  

set folder2 = fso.getFolder(ScreenshotsFolder)

'new folder name with time stamp
'NewFolder = BaseFolder & funGetTimeStamp() & "__" & FileNameCounter
NewFolder = BaseFolder & FileName 

'Count>0 there are files inside the folders
If (folder1Sub.Count>0 or folder2.files.Count>0) then
	fso.CreateFolder (NewFolder)
End if

If (folder1Sub.Count>0) then
	Set objShell = CreateObject("Shell.Application")
	Set objFolder = objShell.NameSpace(NewFolder) 
	objFolder.CopyHere TestResultsFolder 
	Set objFolder = Nothing
	Set objShell = Nothing
End if

If (folder2.files.Count>0) then
	Set objShell = CreateObject("Shell.Application")
	Set objFolder = objShell.NameSpace(NewFolder) 
	objFolder.CopyHere ScreenshotsFolder 
	Set objFolder = Nothing
	Set objShell = Nothing
End if

For Each f1 in folder1Sub
	f1.delete
Next

fso.DeleteFile(ScreenshotsFolder & "*.*")

wshSystemEnv( "TestCaseIDsList" ) = ""

wshSystemEnv( "BatchTotal" ) = 0
wshSystemEnv( "BatchPass" ) = 0
wshSystemEnv( "BatchFail" ) = 0

'MsgBox "Email Sent"

set fso = Nothing
Set wshSystemEnv = Nothing
Set wshShell     = Nothing



'**************************************************************************************
Sub ShowSubFolders(Folder)
    For Each Subfolder in Folder.SubFolders
        'Wscript.Echo Subfolder.Path
        Set objFolder = fso.GetFolder(Subfolder.Path)
        Set colFiles = objFolder.Files
        For Each objFile in colFiles
			'Wscript.Echo objFile.Name
			if objFile.Name = "emailable-report.html" then
				objEmailMessage.AddAttachment Subfolder.Path & "\" & objFile.Name
			End if
        Next
        'Wscript.Echo
        ShowSubFolders Subfolder
    Next
End Sub 
'***************************************************************************************
Function funGetTimeStamp()
		sDateTIme = Now()
		
		iDate = Datepart("d",sDateTime)
		iLen = Len(iDate)
		If iLen = 1 Then
				iDate = "0" & iDate
		End If
		
		sMonth=  mid(MonthName(Datepart("m",sDateTime)),1,3)
		
		iYear = Datepart("yyyy",sDateTime)
		
		iHour = Datepart("h",sDateTime)
		iLen = Len(iHour)
		If iLen = 1 Then
				iHour = "0" & iHour
		End If
		
		iMinute = Datepart("n",sDateTime)
		iLen = Len(iMinute)
		If iLen = 1 Then
				iMinute = "0" & iMinute
		End If
		
		iSec = Datepart("s",sDateTime)
		iLen = Len(iSec)
		If iLen = 1 Then
				iSec = "0" & iSec
		End If
		
		
		funGetTimeStamp =  sMonth & "_" &  iDate & "_" & iYear & "_" & iHour & "_" & iMinute & "_" & iSec 
	 
End Function
'*************************************************************************************
Function IPAddress()
				strQuery = "SELECT * FROM Win32_NetworkAdapterConfiguration WHERE MACAddress > ''"
				Set goWMIService = GetObject( "winmgmts://./root/CIMV2" )
				Set colItems = goWMIService.ExecQuery( strQuery, "WQL", 48 )
				For Each objItem In colItems
					If IsArray( objItem.IPAddress ) Then
						If UBound( objItem.IPAddress ) = 0 Then
							strIP = objItem.IPAddress(0)
						Else
							strIP = Join( objItem.IPAddress, "," )
						End If
					End If
				Next
				Set colItems      = Nothing
                IPAddress = "IP_" & strIP
End Function



