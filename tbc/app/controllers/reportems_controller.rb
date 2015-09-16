class ReportemsController < ApplicationController
  before_action :set_reportem, only: [:show]

  def index
    @reportems = Reportem.all
  end

  def new
    @reportem = Reportem.new
  end

  def create
    @reportem = Reportem.new
    @reportem.update_attributes(idMobibus: params[:idMobibus], fecha: params[:fecha], trayectos: params[:trayectos])
    @reportem.save
    redirect_to reportem_path
  end

  def show
  end

  def destroy
  end

  private

  def set_reportem
    @reportem = Reportem.find(params[:id])
  end
end

