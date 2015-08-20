class ReportemsController < ApplicationController
  before_action :set_reportem, only: [:show, :edit, :update, :destroy]

  # GET /reportems
  # GET /reportems.json
  def index
    @reportems = Reportem.all
  end

  # GET /reportems/1
  # GET /reportems/1.json
  def show
  end

  # GET /reportems/new
  def new
    @reportem = Reportem.new
  end

  # GET /reportems/1/edit
  def edit
  end

  # POST /reportems
  # POST /reportems.json
  def create
    @reportem = Reportem.new(reportem_params)

    respond_to do |format|
      if @reportem.save
        format.html { redirect_to @reportem, notice: 'Reportem was successfully created.' }
        format.json { render :show, status: :created, location: @reportem }
      else
        format.html { render :new }
        format.json { render json: @reportem.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /reportems/1
  # PATCH/PUT /reportems/1.json
  def update
    respond_to do |format|
      if @reportem.update(reportem_params)
        format.html { redirect_to @reportem, notice: 'Reportem was successfully updated.' }
        format.json { render :show, status: :ok, location: @reportem }
      else
        format.html { render :edit }
        format.json { render json: @reportem.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /reportems/1
  # DELETE /reportems/1.json
  def destroy
    @reportem.destroy
    respond_to do |format|
      format.html { redirect_to reportems_url, notice: 'Reportem was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_reportem
      @reportem = Reportem.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def reportem_params
      params.require(:reportem).permit(:fecha, :trayectos)
    end
end
