﻿Imports System.IO

Public Class ViajesRegistros
    Dim filePath As String = "viaje.txt"
    Private Sub ViajesRegistros_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        LoadData()
    End Sub


    Private Sub LoadData()
        Dim destinosFilePath As String = "destinos.txt"
        Dim clientesFilePath As String = "clientes.txt"

        listBoxDestinos.Items.Clear()
        listBoxClientes.Items.Clear()

        Try
            LoadDestinos(destinosFilePath)

            LoadClientes(clientesFilePath)

        Catch ex As Exception
            MessageBox.Show("Error loading data: " & ex.Message)
        End Try
    End Sub

    Private Sub LoadDestinos(filePath As String)
        ' Check if the file exists
        If Not File.Exists(filePath) Then
            MessageBox.Show("File not found: " & filePath)
            Return
        End If

        Using reader As New StreamReader(filePath)
            While Not reader.EndOfStream
                Dim line As String = reader.ReadLine().Trim()
                If Not String.IsNullOrWhiteSpace(line) Then
                    Dim parts As String() = line.Split("-")
                    Dim destino As String = parts(0).Trim()
                    listBoxDestinos.Items.Add(destino)
                End If
            End While
        End Using
    End Sub

    Private Sub LoadClientes(filePath As String)
        ' Check if the file exists
        If Not File.Exists(filePath) Then
            MessageBox.Show("File not found: " & filePath)
            Return
        End If

        Using reader As New StreamReader(filePath)
            While Not reader.EndOfStream
                Dim line As String = reader.ReadLine().Trim()
                If Not String.IsNullOrWhiteSpace(line) Then
                    Dim parts As String() = line.Split("€"c)

                    Dim firstName As String = parts(0).Trim()
                    Dim secondName As String = parts(1).Trim()

                    Dim fullName As String = $"{firstName} {secondName}"
                    listBoxClientes.Items.Add(fullName)

                End If
            End While
        End Using
    End Sub

    Private Sub btnBack_Click(sender As Object, e As EventArgs) Handles btnBack.Click
        Me.Close()
        Viajes.Show()
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        SaveTravel()
    End Sub

    Public Sub SaveTravel()
        Try
            Dim destino As String = listBoxDestinos.SelectedItem
            Dim cliente As String = listBoxClientes.SelectedItem
            Dim fecha As String = calendar.SelectionStart.ToShortDateString

            Dim destinoCompleto As String = $"{cliente}-{destino}-{fecha}#"

            Using writer As New StreamWriter(filePath, True)
                writer.WriteLine(destinoCompleto)
            End Using
        Catch ex As Exception
            MessageBox.Show("Error: " + ex.Message)
        End Try
    End Sub


End Class