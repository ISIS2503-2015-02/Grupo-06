require 'test_helper'

class VcubsControllerTest < ActionController::TestCase
  setup do
    @vcub = vcubs(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:vcubs)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create vcub" do
    assert_difference('Vcub.count') do
      post :create, vcub: { estado: @vcub.estado, posicion: @vcub.posicion, prestada: @vcub.prestada }
    end

    assert_redirected_to vcub_path(assigns(:vcub))
  end

  test "should show vcub" do
    get :show, id: @vcub
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @vcub
    assert_response :success
  end

  test "should update vcub" do
    patch :update, id: @vcub, vcub: { estado: @vcub.estado, posicion: @vcub.posicion, prestada: @vcub.prestada }
    assert_redirected_to vcub_path(assigns(:vcub))
  end

  test "should destroy vcub" do
    assert_difference('Vcub.count', -1) do
      delete :destroy, id: @vcub
    end

    assert_redirected_to vcubs_path
  end
end
