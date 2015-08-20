class ReportetsController < ApplicationController
  before_action :set_reportet, only: [:show, :edit, :update, :destroy]

  # GET /reportets
  # GET /reportets.json
  def index
    @reportets = Reportet.all
  end

  # GET /reportets/1
  # GET /reportets/1.json
  def show
  end

  # GET /reportets/new
  def new
    @reportet = Reportet.new
  end

  # GET /reportets/1/edit
  def edit
  end

  # POST /reportets
  # POST /reportets.json
  def create
    @reportet = Reportet.new(reportet_params)

    respond_to do |format|
      if @reportet.save
        format.html { redirect_to @reportet, notice: 'Reportet was successfully created.' }
        format.json { render :show, status: :created, location: @reportet }
      else
        format.html { render :new }
        format.json { render json: @reportet.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /reportets/1
  # PATCH/PUT /reportets/1.json
  def update
    respond_to do |format|
      if @reportet.update(reportet_params)
        format.html { redirect_to @reportet, notice: 'Reportet was successfully updated.' }
        format.json { render :show, status: :ok, location: @reportet }
      else
        format.html { render :edit }
        format.json { render json: @reportet.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /reportets/1
  # DELETE /reportets/1.json
  def destroy
    @reportet.destroy
    respond_to do |format|
      format.html { redirect_to reportets_url, notice: 'Reportet was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_reportet
      @reportet = Reportet.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def reportet_params
      params.require(:reportet).permit(:fecha, :trayectos, :tiempopromedio)
    end
end
