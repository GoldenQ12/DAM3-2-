<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Viajes
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
        Me.FlowLayoutPanel1 = New System.Windows.Forms.FlowLayoutPanel()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.Button1 = New System.Windows.Forms.Button()
        Me.btnBack = New System.Windows.Forms.Button()
        Me.btnClientes = New System.Windows.Forms.Button()
        Me.btnDestinos = New System.Windows.Forms.Button()
        Me.btnViajes = New System.Windows.Forms.Button()
        Me.FlowLayoutPanel1.SuspendLayout()
        Me.SuspendLayout()
        '
        'FlowLayoutPanel1
        '
        Me.FlowLayoutPanel1.Controls.Add(Me.btnClientes)
        Me.FlowLayoutPanel1.Controls.Add(Me.btnDestinos)
        Me.FlowLayoutPanel1.Controls.Add(Me.btnViajes)
        Me.FlowLayoutPanel1.Location = New System.Drawing.Point(329, 288)
        Me.FlowLayoutPanel1.Margin = New System.Windows.Forms.Padding(5)
        Me.FlowLayoutPanel1.Name = "FlowLayoutPanel1"
        Me.FlowLayoutPanel1.Size = New System.Drawing.Size(990, 307)
        Me.FlowLayoutPanel1.TabIndex = 0
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Font = New System.Drawing.Font("Microsoft Sans Serif", 72.0!, CType((System.Drawing.FontStyle.Bold Or System.Drawing.FontStyle.Italic), System.Drawing.FontStyle), System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label6.ImageAlign = System.Drawing.ContentAlignment.TopCenter
        Me.Label6.Location = New System.Drawing.Point(326, 126)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(1010, 108)
        Me.Label6.TabIndex = 15
        Me.Label6.Text = "AGENCIA DE VIAJES"
        Me.Label6.TextAlign = System.Drawing.ContentAlignment.MiddleRight
        '
        'Button1
        '
        Me.Button1.AutoSize = True
        Me.Button1.BackColor = System.Drawing.SystemColors.ButtonShadow
        Me.Button1.Font = New System.Drawing.Font("Microsoft Sans Serif", 15.75!, CType((System.Drawing.FontStyle.Bold Or System.Drawing.FontStyle.Italic), System.Drawing.FontStyle), System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Button1.Image = Global.VIajesAgencia.My.Resources.Resources.admin
        Me.Button1.Location = New System.Drawing.Point(616, 662)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(416, 163)
        Me.Button1.TabIndex = 14
        Me.Button1.Text = "GESTIONAR DESTINOS"
        Me.Button1.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText
        Me.Button1.UseVisualStyleBackColor = False
        '
        'btnBack
        '
        Me.btnBack.AutoSize = True
        Me.btnBack.BackColor = System.Drawing.SystemColors.ButtonShadow
        Me.btnBack.Font = New System.Drawing.Font("Microsoft Sans Serif", 15.75!, CType((System.Drawing.FontStyle.Bold Or System.Drawing.FontStyle.Italic), System.Drawing.FontStyle), System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnBack.Image = Global.VIajesAgencia.My.Resources.Resources.exit11
        Me.btnBack.Location = New System.Drawing.Point(1423, 839)
        Me.btnBack.Name = "btnBack"
        Me.btnBack.Size = New System.Drawing.Size(149, 134)
        Me.btnBack.TabIndex = 13
        Me.btnBack.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageBeforeText
        Me.btnBack.UseVisualStyleBackColor = False
        '
        'btnClientes
        '
        Me.btnClientes.BackColor = System.Drawing.SystemColors.ButtonShadow
        Me.btnClientes.Dock = System.Windows.Forms.DockStyle.Bottom
        Me.btnClientes.Font = New System.Drawing.Font("Microsoft Sans Serif", 24.0!, CType((System.Drawing.FontStyle.Bold Or System.Drawing.FontStyle.Italic), System.Drawing.FontStyle), System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnClientes.Image = Global.VIajesAgencia.My.Resources.Resources.clientes
        Me.btnClientes.Location = New System.Drawing.Point(15, 15)
        Me.btnClientes.Margin = New System.Windows.Forms.Padding(15)
        Me.btnClientes.Name = "btnClientes"
        Me.btnClientes.Padding = New System.Windows.Forms.Padding(15)
        Me.btnClientes.Size = New System.Drawing.Size(298, 271)
        Me.btnClientes.TabIndex = 0
        Me.btnClientes.Text = "CLIENTES"
        Me.btnClientes.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText
        Me.btnClientes.UseVisualStyleBackColor = False
        '
        'btnDestinos
        '
        Me.btnDestinos.BackColor = System.Drawing.SystemColors.ButtonShadow
        Me.btnDestinos.Dock = System.Windows.Forms.DockStyle.Bottom
        Me.btnDestinos.Font = New System.Drawing.Font("Microsoft Sans Serif", 24.0!, CType((System.Drawing.FontStyle.Bold Or System.Drawing.FontStyle.Italic), System.Drawing.FontStyle), System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnDestinos.Image = Global.VIajesAgencia.My.Resources.Resources.location
        Me.btnDestinos.Location = New System.Drawing.Point(343, 15)
        Me.btnDestinos.Margin = New System.Windows.Forms.Padding(15)
        Me.btnDestinos.Name = "btnDestinos"
        Me.btnDestinos.Padding = New System.Windows.Forms.Padding(15)
        Me.btnDestinos.Size = New System.Drawing.Size(298, 271)
        Me.btnDestinos.TabIndex = 1
        Me.btnDestinos.Text = "DESTINOS"
        Me.btnDestinos.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText
        Me.btnDestinos.UseVisualStyleBackColor = False
        '
        'btnViajes
        '
        Me.btnViajes.BackColor = System.Drawing.SystemColors.ButtonShadow
        Me.btnViajes.Dock = System.Windows.Forms.DockStyle.Bottom
        Me.btnViajes.Font = New System.Drawing.Font("Microsoft Sans Serif", 24.0!, CType((System.Drawing.FontStyle.Bold Or System.Drawing.FontStyle.Italic), System.Drawing.FontStyle), System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnViajes.Image = Global.VIajesAgencia.My.Resources.Resources.travel
        Me.btnViajes.Location = New System.Drawing.Point(671, 15)
        Me.btnViajes.Margin = New System.Windows.Forms.Padding(15)
        Me.btnViajes.Name = "btnViajes"
        Me.btnViajes.Padding = New System.Windows.Forms.Padding(15)
        Me.btnViajes.Size = New System.Drawing.Size(298, 271)
        Me.btnViajes.TabIndex = 2
        Me.btnViajes.Text = "VIAJES"
        Me.btnViajes.TextImageRelation = System.Windows.Forms.TextImageRelation.ImageAboveText
        Me.btnViajes.UseVisualStyleBackColor = False
        '
        'Viajes
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.SystemColors.ControlDarkDark
        Me.ClientSize = New System.Drawing.Size(1584, 985)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.btnBack)
        Me.Controls.Add(Me.FlowLayoutPanel1)
        Me.Name = "Viajes"
        Me.Text = "Viajes"
        Me.FlowLayoutPanel1.ResumeLayout(False)
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents FlowLayoutPanel1 As FlowLayoutPanel
    Friend WithEvents btnClientes As Button
    Friend WithEvents btnDestinos As Button
    Friend WithEvents btnViajes As Button
    Friend WithEvents btnBack As Button
    Friend WithEvents Button1 As Button
    Friend WithEvents Label6 As Label
End Class
