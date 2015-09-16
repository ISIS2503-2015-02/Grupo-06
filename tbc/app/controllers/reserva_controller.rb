class ReservaController < ApplicationController

  before_action :set_reserva, only: [:show]

  def index
    @reserva = Reserva.all
  end

  def create
    @reserva = Reserva.new
    fecha = Time.now
    @reserva.update_attributes(estado: params[:estado],fecha:fecha, direccion_salida: params[:direccionOrigen], diraccion_llegada: params[:direccionDestino], hora_de_salida:  params[:horaSalida], hora_de_llegada: params[:horaLlegada], ruta: params[:ruta], distancia: params[:distancia], id_usuario: params[:idUsuario]  )
    @reserva.save
    redirect_to reserva_path

  end

  def show
  end

  def destroy
  end

  private

  def set_reserva
    @reserva = Reserva.find(params[:id])
  end
end
