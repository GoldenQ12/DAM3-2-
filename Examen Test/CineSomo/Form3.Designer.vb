<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form3
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
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
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.btnBack = New System.Windows.Forms.Button()
        Me.txtEntradas = New System.Windows.Forms.NumericUpDown()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.btnComprar = New System.Windows.Forms.Button()
        Me.lblHora = New System.Windows.Forms.Label()
        Me.lblInfo = New System.Windows.Forms.Label()
        CType(Me.txtEntradas, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'btnBack
        '
        Me.btnBack.Location = New System.Drawing.Point(695, 402)
        Me.btnBack.Name = "btnBack"
        Me.btnBack.Size = New System.Drawing.Size(93, 36)
        Me.btnBack.TabIndex = 3
        Me.btnBack.Text = "VOLVER"
        Me.btnBack.UseVisualStyleBackColor = True
        '
        'txtEntradas
        '
        Me.txtEntradas.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtEntradas.Location = New System.Drawing.Point(343, 188)
        Me.txtEntradas.Name = "txtEntradas"
        Me.txtEntradas.Size = New System.Drawing.Size(120, 29)
        Me.txtEntradas.TabIndex = 4
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(124, 190)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(213, 24)
        Me.Label1.TabIndex = 5
        Me.Label1.Text = "CANTIDAD ENTRADAS"
        '
        'btnComprar
        '
        Me.btnComprar.Location = New System.Drawing.Point(280, 229)
        Me.btnComprar.Name = "btnComprar"
        Me.btnComprar.Size = New System.Drawing.Size(261, 49)
        Me.btnComprar.TabIndex = 6
        Me.btnComprar.Text = "COMPRAR"
        Me.btnComprar.UseVisualStyleBackColor = True
        '
        'lblHora
        '
        Me.lblHora.AutoSize = True
        Me.lblHora.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblHora.Location = New System.Drawing.Point(250, 77)
        Me.lblHora.Name = "lblHora"
        Me.lblHora.Size = New System.Drawing.Size(213, 24)
        Me.lblHora.TabIndex = 7
        Me.lblHora.Text = "CANTIDAD ENTRADAS"
        '
        'lblInfo
        '
        Me.lblInfo.AutoSize = True
        Me.lblInfo.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblInfo.Location = New System.Drawing.Point(548, 26)
        Me.lblInfo.Name = "lblInfo"
        Me.lblInfo.Size = New System.Drawing.Size(213, 24)
        Me.lblInfo.TabIndex = 8
        Me.lblInfo.Text = "CANTIDAD ENTRADAS"
        '
        'Form3
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(800, 450)
        Me.Controls.Add(Me.lblInfo)
        Me.Controls.Add(Me.lblHora)
        Me.Controls.Add(Me.btnComprar)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.txtEntradas)
        Me.Controls.Add(Me.btnBack)
        Me.Name = "Form3"
        Me.Text = "Form3"
        CType(Me.txtEntradas, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents btnBack As Button
    Friend WithEvents txtEntradas As NumericUpDown
    Friend WithEvents Label1 As Label
    Friend WithEvents btnComprar As Button
    Friend WithEvents lblHora As Label
    Friend WithEvents lblInfo As Label
End Class
