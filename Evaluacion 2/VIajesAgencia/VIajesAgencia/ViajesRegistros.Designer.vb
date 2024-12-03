<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class ViajesRegistros
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()>
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()>
    Private Sub InitializeComponent()
        Me.listBoxDestinos = New System.Windows.Forms.ListBox()
        Me.listBoxClientes = New System.Windows.Forms.ListBox()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.calendar = New System.Windows.Forms.MonthCalendar()
        Me.btnBack = New System.Windows.Forms.Button()
        Me.Button1 = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'listBoxDestinos
        '
        Me.listBoxDestinos.Font = New System.Drawing.Font("Microsoft Sans Serif", 15.75!, CType((System.Drawing.FontStyle.Bold Or System.Drawing.FontStyle.Italic), System.Drawing.FontStyle), System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.listBoxDestinos.FormattingEnabled = True
        Me.listBoxDestinos.ItemHeight = 25
        Me.listBoxDestinos.Location = New System.Drawing.Point(393, 240)
        Me.listBoxDestinos.Name = "listBoxDestinos"
        Me.listBoxDestinos.Size = New System.Drawing.Size(376, 129)
        Me.listBoxDestinos.TabIndex = 0
        '
        'listBoxClientes
        '
        Me.listBoxClientes.Font = New System.Drawing.Font("Microsoft Sans Serif", 15.75!, CType((System.Drawing.FontStyle.Bold Or System.Drawing.FontStyle.Italic), System.Drawing.FontStyle), System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.listBoxClientes.FormattingEnabled = True
        Me.listBoxClientes.ItemHeight = 25
        Me.listBoxClientes.Location = New System.Drawing.Point(833, 240)
        Me.listBoxClientes.Name = "listBoxClientes"
        Me.listBoxClientes.Size = New System.Drawing.Size(376, 129)
        Me.listBoxClientes.TabIndex = 1
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Font = New System.Drawing.Font("Microsoft Sans Serif", 72.0!, CType((System.Drawing.FontStyle.Bold Or System.Drawing.FontStyle.Italic), System.Drawing.FontStyle), System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label6.ImageAlign = System.Drawing.ContentAlignment.TopCenter
        Me.Label6.Location = New System.Drawing.Point(632, 56)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(382, 108)
        Me.Label6.TabIndex = 10
        Me.Label6.Text = "VIAJES"
        Me.Label6.TextAlign = System.Drawing.ContentAlignment.MiddleRight
        '
        'calendar
        '
        Me.calendar.Font = New System.Drawing.Font("Microsoft Sans Serif", 24.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.calendar.Location = New System.Drawing.Point(721, 546)
        Me.calendar.MinDate = New Date(2024, 12, 2, 0, 0, 0, 0)
        Me.calendar.Name = "calendar"
        Me.calendar.TabIndex = 11
        '
        'btnBack
        '
        Me.btnBack.AutoSize = True
        Me.btnBack.Font = New System.Drawing.Font("Microsoft Sans Serif", 15.75!, CType((System.Drawing.FontStyle.Bold Or System.Drawing.FontStyle.Italic), System.Drawing.FontStyle), System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnBack.Location = New System.Drawing.Point(1337, 913)
        Me.btnBack.Name = "btnBack"
        Me.btnBack.Size = New System.Drawing.Size(235, 60)
        Me.btnBack.TabIndex = 13
        Me.btnBack.Text = "VOLVER"
        Me.btnBack.UseVisualStyleBackColor = True
        '
        'Button1
        '
        Me.Button1.AutoSize = True
        Me.Button1.Font = New System.Drawing.Font("Microsoft Sans Serif", 15.75!, CType((System.Drawing.FontStyle.Bold Or System.Drawing.FontStyle.Italic), System.Drawing.FontStyle), System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Button1.Location = New System.Drawing.Point(650, 720)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(327, 60)
        Me.Button1.TabIndex = 14
        Me.Button1.Text = "GUARDAR"
        Me.Button1.UseVisualStyleBackColor = True
        '
        'ViajesRegistros
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(1584, 985)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.btnBack)
        Me.Controls.Add(Me.calendar)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.listBoxClientes)
        Me.Controls.Add(Me.listBoxDestinos)
        Me.Name = "ViajesRegistros"
        Me.Text = "ViajesRegistros"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents listBoxDestinos As ListBox
    Friend WithEvents listBoxClientes As ListBox
    Friend WithEvents Label6 As Label
    Friend WithEvents calendar As MonthCalendar
    Friend WithEvents btnBack As Button
    Friend WithEvents Button1 As Button
End Class
