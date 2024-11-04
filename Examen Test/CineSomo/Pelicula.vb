Imports System.Runtime.Remoting

Public Class Pelicula
    Private Property _nombre As String
    Private Property _director As String
    Private Property _actores As String() = {}
    Private Property _duracion As Integer
    Private Property _anio As Integer

    Public Property Nombre() As String
        Get
            Return _nombre
        End Get
        Set(value As String)
            _nombre = value
        End Set
    End Property

    Public Property Director() As String
        Get
            Return _director
        End Get
        Set(value As String)
            _director = value
        End Set
    End Property

    Public Property Actores() As String()
        Get
            Return _actores
        End Get
        Set(value As String())
            _actores = value
        End Set
    End Property

    Public Property Duracion() As Integer
        Get
            Return _duracion
        End Get
        Set(value As Integer)
            _duracion = value
        End Set
    End Property

    Public Property Anio() As Integer
        Get
            Return _anio
        End Get
        Set(value As Integer)
            _anio = value
        End Set
    End Property

    Public Sub New()
        _nombre = ""
        _director = ""
        _actores = {}
        _duracion = 0
        _anio = DateTime.Now.Year
    End Sub

    Public Sub New(ByVal peli As String)
        _nombre = peli
        _director = ""
        _actores = {}
        _duracion = 0
        _anio = DateTime.Now.Year
    End Sub

    Public Overrides Function ToString() As String
        Return "Nombre peli: " & _nombre & Environment.NewLine & "Director: " & _director & Environment.NewLine & "Actores: " & String.Join(", ", _actores) & Environment.NewLine & "Duracion: " & _duracion & Environment.NewLine & "Anio: " & _anio
    End Function

End Class
